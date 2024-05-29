package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.BreakdownDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
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
