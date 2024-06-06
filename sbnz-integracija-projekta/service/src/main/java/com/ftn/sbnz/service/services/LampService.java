package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Lamp;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.services.interfaces.ILampService;
import com.ftn.util.Util;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LampService implements ILampService {

    @Autowired
    ICarRepository allCars;

    @Override
    public List<RepairmentDTO> getRepairmentByLamps(List<Lamp> lamps, Integer carId) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("bwKsession");

        Car car = allCars.findById(carId).get();

        for (Lamp lamp: lamps) {
            lamp.setPlate(car.getPlate());
            ksession.insert(lamp);
        }
        ksession.insert(car);

        List<Repairment> previous = ksession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .collect(Collectors.toList());

        int ruleCount = ksession.fireAllRules();
        System.out.println(ruleCount);

        ksession.halt();
         List<Repairment> after = ksession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .collect(Collectors.toList());

        // after - previous
        return Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).collect(Collectors.toList());

    }
}
