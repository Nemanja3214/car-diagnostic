package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.model.models.Lamp;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ILampService {
    List<RepairmentDTO> getRepairmentByLamps(List<Lamp> lamps, Integer carId);
}
