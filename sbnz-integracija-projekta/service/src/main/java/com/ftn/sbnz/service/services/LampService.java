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

@Service
public class LampService implements ILampService {

    @Autowired
    ICarRepository allCars;

    @Override
    public List<RepairmentDTO> getRepairmentByLamps(List<Lamp> lamps, Integer carId) {
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        // System.out.println(container);
        KieSession ksession = container.newKieSession("bwKsession");

        Car car = allCars.findById(carId).get();

        for (Lamp lamp: lamps) {
            lamp.setPlate(car.getPlate());
            ksession.insert(lamp);
        }
        ksession.insert(car);

        List<Repairment> previous = ksession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .toList();

        int ruleCount = ksession.fireAllRules();
        System.out.println(ruleCount);

        ksession.halt();
         List<Repairment> after = ksession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .toList();

        // after - previous
        return Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).toList();

    }
}
