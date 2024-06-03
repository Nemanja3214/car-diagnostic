package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Lamp;
import com.ftn.sbnz.model.models.LampKind;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.IBreakdownRepository;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.repositories.ILampRepository;
import com.ftn.sbnz.service.repositories.IRepairmentRepository;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import com.ftn.util.Util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
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

    private KieSession kSession;

    public BreakdownService(){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        // System.out.println(container);
        kSession = container.newKieSession("carKsession");
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
        .toList();

     
        kSession.insert(breakdown);
        int ruleCount = kSession.fireAllRules();
        System.out.println(ruleCount);

        kSession.halt();
         List<Repairment> after = kSession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .toList();

        // after - previous
        return Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).toList();

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
}
