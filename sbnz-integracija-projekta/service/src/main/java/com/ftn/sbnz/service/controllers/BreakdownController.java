package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
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

    @PreAuthorize("hasAnyAuthority('ROLE_CLIENT')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateBreakdownDTO dto) throws NotFoundException {
        breakdownService.create(dto);
        return ResponseEntity.ok("OK");
    }

    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) throws NotFoundException {
        BreakdownDTO dto = breakdownService.get(id);
        return ResponseEntity.ok(dto);
    }

    @PermitAll
    @GetMapping("symptoms")
    public ResponseEntity<?> getSymptoms() throws NotFoundException {
        List<String> symptoms = breakdownService.getSymptoms();
        return ResponseEntity.ok(symptoms);
    }
}
