package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.models.Lamp;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.services.interfaces.ILampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/lamp")
public class LampController {

    @Autowired
    ILampService lampService;

    @PermitAll
    @PostMapping("/check/{carId}")
    public ResponseEntity<?> create(@RequestBody List<Lamp> lamps, @PathVariable Integer carId) {
        List<RepairmentDTO> repairmentDTOs = lampService.getRepairmentByLamps(lamps, carId);
        return ResponseEntity.ok(repairmentDTOs);
    }
}
