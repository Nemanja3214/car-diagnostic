package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.Lamp;
import com.ftn.sbnz.model.models.LampKind;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.model.models.battery.Battery;
import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
import com.ftn.sbnz.model.models.battery.events.VoltageReadingEvent;
import com.ftn.sbnz.service.dtos.breakdown.BatteryCheckDTO;
import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CurrentReadingDTO;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.IBreakdownRepository;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.repositories.IElectricCarRepository;
import com.ftn.sbnz.service.repositories.ILampRepository;
import com.ftn.sbnz.service.repositories.IRepairmentRepository;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import com.ftn.util.Simulation;
import com.ftn.util.Util;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BreakdownService implements IBreakdownService {
    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private IBreakdownRepository breakdownRepository;

    @Autowired
    private ILampRepository lampRepository;

    @Autowired
    private IRepairmentRepository repairmentRepository;

    @Autowired
    private IElectricCarRepository electricCarRepository;

    private KieSession kSession;

    private KieSession cepKSession;
    private KieContainer container;

    public BreakdownService(){
        container = KieServices.Factory.get().getKieClasspathContainer();
        // System.out.println(container);
        kSession = container.newKieSession("carKsession");
        cepKSession = container.newKieSession("cepKsession");
       
    }

    // @Autowired
    // private KieContainer container;

    @Override
    public List<BreakdownDTO> getAll() {
        return breakdownRepository.findAll().stream().map(BreakdownDTO::toDTO).collect(Collectors.toList());
    }


    @Override
    public List<RepairmentDTO> create(CreateBreakdownDTO dto) throws NotFoundException {
        Breakdown breakdown = new Breakdown();

        if(!carRepository.existsById(dto.getCarId()))
            throw new NotFoundException();

        breakdown.setName(dto.getName());
        boolean hasInvalidSymptom = dto.getSymptoms().stream()
                .anyMatch(str -> Symptom.fromString(str) == null);
        if(hasInvalidSymptom)
            throw new NotFoundException();
        breakdown.setSymptoms(dto.getSymptoms().stream().map(Symptom::fromString).collect(Collectors.toList()));

        Car car = carRepository.findById(dto.getCarId()).orElseThrow(NotFoundException::new);
        breakdown.setCar(car);

        if(dto.isEngineLamp()){
            // System.out.println("ENGINE LAMP ON");
            String lampStr = LampKind.ENGINE.getStringValue();
            if(lampStr == null)
                throw new NotFoundException();
            Lamp lamp = new Lamp();
            lamp.setLampKind(lampStr);
            lampRepository.save(lamp);
        }

        breakdown = breakdownRepository.save(breakdown);

        // get newly created objects

        List<Repairment> previous = kSession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .collect(Collectors.toList());

     
        kSession.insert(breakdown);
        int ruleCount = kSession.fireAllRules();
        System.out.println(ruleCount);

        kSession.halt();
         List<Repairment> after = kSession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .collect(Collectors.toList());

        // after - previous
        return Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).collect(Collectors.toList());

    }

    @Override
    public BreakdownDTO get(Integer id) {
        return BreakdownDTO.toDTO(breakdownRepository.findById(id).orElse(null));
    }

    @Override
    public List<String> getSymptoms() {

        List<String> stringValues = new ArrayList<>();
        for (Symptom symptom : Symptom.values()) {
            if(symptom.isShow())
                stringValues.add(symptom.getStringValue());
        }
        return stringValues;
    }

    @Override
    public BatteryCheckDTO checkBattery(int carId, int caseScenarion) throws InterruptedException, NotFoundException {
           Breakdown breakdown = new Breakdown();

        //    TODO check if electrical
        if(!carRepository.existsById(carId))
            throw new NotFoundException();

        breakdown.setName("Battery check");
        ElectricCar car = electricCarRepository.findById(carId).orElseThrow(NotFoundException::new);
        breakdown.setCar(car);

        breakdown = breakdownRepository.save(breakdown);

        // get newly created objects
        cepKSession = container.newKieSession("cepKsession");
        List<Repairment> previous = cepKSession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .collect(Collectors.toList());

        Battery battery = car.getBattery();
        battery.setCurrentBreakdownId(breakdown.getId());
        
        double scale = 20.0;
        cepKSession.setGlobal("tolerance", 0.01);
  
        LocalDateTime now = LocalDateTime.now();
        // SessionPseudoClock clock = cepKSession.getSessionClock();

        double currentValue = Simulation.calculateValue(scale, now.toLocalTime());
        double voltageValue = Simulation.calculateValue(scale, now.toLocalTime());
        System.out.println(currentValue);
        System.out.println(voltageValue);
        cepKSession.insert(battery);
        cepKSession.insert(breakdown);

        if(caseScenarion == 1){
            do{
                    CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, battery.getId(), Util.localToDate(now));
                    VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, battery.getId(), Util.localToDate(now));

                    cepKSession.insert(voltageEvent);
                    cepKSession.insert(currentReadingEvent);
                    cepKSession.getAgenda().getAgendaGroup("checking battery").setFocus();
                    cepKSession.fireAllRules();
                    cepKSession.halt();
                    System.out.println(currentValue);
                    //   System.out.println(voltageValue);
                    Thread.sleep(1000);

                    // advance time
                    // clock.advanceTime( 1, TimeUnit.SECONDS );
                    now = now.plusSeconds(1);


                    currentValue = Simulation.calculateValue(scale, now.toLocalTime());
                    voltageValue = Simulation.calculateValue(scale, now.toLocalTime());
                    // System.out.println(now.toString());
                    //  System.out.println(clock.getCurrentTime().toString());
                
                }while(!Simulation.finished);
                Simulation.lastStart = null;
                Simulation.finished = false;
        }
        else if(caseScenarion == 2){
            do{
                    CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, battery.getId(), Util.localToDate(now));
                    VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, battery.getId(), Util.localToDate(now));

                    cepKSession.insert(voltageEvent);
                    cepKSession.insert(currentReadingEvent);
                    cepKSession.getAgenda().getAgendaGroup("checking battery").setFocus();
                    cepKSession.fireAllRules();
                    cepKSession.halt();
                    System.out.println(currentValue);
                    //   System.out.println(voltageValue);
                    Thread.sleep(1000);

                    // advance time
                    // clock.advanceTime( 1, TimeUnit.SECONDS );
                    now = now.plusSeconds(1);


                    currentValue = Simulation.calculateDegradationValue(scale, now.toLocalTime());
                    voltageValue = Simulation.calculateDegradationValue(scale, now.toLocalTime());
                    // System.out.println(now.toString());
                    //  System.out.println(clock.getCurrentTime().toString());
                
                }while(!Simulation.finished);
                Simulation.lastStart = null;
                Simulation.finished = false;
        }
        else{
            CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, battery.getId(), Util.localToDate(now));
            VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, battery.getId(), Util.localToDate(now));

            cepKSession.insert(voltageEvent);
            cepKSession.insert(currentReadingEvent);
            cepKSession.getAgenda().getAgendaGroup("checking battery").setFocus();
            cepKSession.fireAllRules();
            cepKSession.halt();
              System.out.println(currentValue);
            //   System.out.println(voltageValue);
            Thread.sleep(60 * 1000);

            // advance time
            // clock.advanceTime( 80, TimeUnit.SECONDS );
            now = now.plusSeconds(61);

            currentReadingEvent = new CurrentReadingEvent(currentValue, battery.getId(), Util.localToDate(now));
            voltageEvent = new VoltageReadingEvent(voltageValue, battery.getId(), Util.localToDate(now));

            cepKSession.getAgenda().getAgendaGroup("checking battery").setFocus();
            cepKSession.fireAllRules();
            cepKSession.halt();
          
            Simulation.lastStart = null;
            Simulation.finished = false;
        }

      
  

     
        // cepKSession.insert(breakdown);
        // int ruleCount = cepKSession.fireAllRules();
        // System.out.println(ruleCount);

        // cepKSession.halt();
         List<Repairment> after = cepKSession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
         .collect(Collectors.toList());

        BatteryCheckDTO dto = new BatteryCheckDTO();
        dto.setRepairments(Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).collect(Collectors.toList()));
        List<CurrentReadingDTO> readingDTOs = cepKSession.getObjects().stream()
        .filter(a -> a instanceof CurrentReadingEvent)
        .map(a -> CurrentReadingDTO.toDTO((CurrentReadingEvent)a))
        .collect(Collectors.toList());
        
        dto.setCurrentReadings(readingDTOs);

        cepKSession.dispose();

        // after - previous
        return dto;
    }
}
