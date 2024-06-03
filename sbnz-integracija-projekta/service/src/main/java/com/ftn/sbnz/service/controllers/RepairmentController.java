package com.ftn.sbnz.service.controllers;


import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.IRepairmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/repairment")
public class RepairmentController {

    @Autowired
    IRepairmentService repairmentService;

    @PermitAll
    @GetMapping("/getAll/{carId}")
    public ResponseEntity<List<RepairmentDTO>> getCarInfo(@PathVariable Integer carId) throws NotFoundException {
        return ResponseEntity.ok(repairmentService.getByCarId(carId));
    }
}
