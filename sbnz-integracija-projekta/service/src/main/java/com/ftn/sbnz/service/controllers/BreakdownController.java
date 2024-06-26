package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
import com.ftn.sbnz.service.dtos.breakdown.BatteryCheckDTO;
import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CurrentReadingDTO;
import com.ftn.sbnz.service.dtos.breakdown.SymptomsDTO;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/breakdown")
public class BreakdownController {
    @Autowired
    private IBreakdownService breakdownService;

    //TODO add exception handler
    @PermitAll
    @GetMapping
    public ResponseEntity<?> getAll() throws NotFoundException {
        List<BreakdownDTO> breakdownDTOS = breakdownService.getAll();
        return ResponseEntity.ok(breakdownDTOS);
    }

    @PermitAll
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateBreakdownDTO dto) throws NotFoundException {
        List<RepairmentDTO> repairmentDTOs = breakdownService.create(dto);
        return ResponseEntity.ok(repairmentDTOs);
    }

    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) throws NotFoundException {
        BreakdownDTO dto = breakdownService.get(id);
        return ResponseEntity.ok(dto);
    }

    @PermitAll
    @GetMapping("symptoms")
    public ResponseEntity<?> getSymptoms(@RequestParam String purpose) throws NotFoundException {
        List<String> symptoms = breakdownService.getSymptoms(purpose);
        return ResponseEntity.ok(symptoms);
    }

     @PermitAll
    @GetMapping("check-battery/{carId}")
    public ResponseEntity<?> checkBattery(@PathVariable int carId, @RequestParam int caseScenario) throws NotFoundException, InterruptedException {
        BatteryCheckDTO dto = breakdownService.checkBattery(carId, caseScenario);
        return ResponseEntity.ok(dto);
    }

         @PermitAll
    @PostMapping("same-symptoms")
    public ResponseEntity<?> sameSymptoms(@RequestBody SymptomsDTO dto) throws NotFoundException, InterruptedException {
        Long num = breakdownService.countSameSymptoms(dto);
        return ResponseEntity.ok(num);
    }

}
