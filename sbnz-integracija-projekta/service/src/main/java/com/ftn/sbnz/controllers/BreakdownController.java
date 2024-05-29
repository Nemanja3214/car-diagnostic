package com.ftn.sbnz.controllers;

import com.ftn.sbnz.dtos.BreakdownDTO;
import com.ftn.sbnz.dtos.car.CarDTO;
import com.ftn.sbnz.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.dtos.car.GasCarDTO;
import com.ftn.sbnz.exceptions.NotFoundException;
import com.ftn.sbnz.services.interfaces.IBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
