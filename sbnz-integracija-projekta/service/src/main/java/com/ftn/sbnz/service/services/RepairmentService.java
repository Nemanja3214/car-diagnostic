package com.ftn.sbnz.service.services;


import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.repositories.IRepairmentRepository;
import com.ftn.sbnz.service.services.interfaces.IRepairmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepairmentService implements IRepairmentService {

    @Autowired
    IRepairmentRepository allRepairments;

    @Override
    public List<RepairmentDTO> getByCarId(Integer carId) {
        List<Repairment> allReps = allRepairments.findAllByCarId(carId);
        List<RepairmentDTO> ret = new ArrayList<RepairmentDTO>();
        for (Repairment r: allReps) {
            ret.add(new RepairmentDTO(r));
        }
        return ret;
    }
}