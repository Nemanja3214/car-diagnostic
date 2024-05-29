package com.ftn.sbnz.controllers;


import com.ftn.sbnz.dtos.MechanicDTO;
import com.ftn.sbnz.exceptions.NotFoundException;
import com.ftn.sbnz.services.interfaces.IMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.annotation.security.PermitAll;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/mechanic")
public class MechanicController {
    @Autowired
    IMechanicService mechanicService;

    @PermitAll
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MechanicDTO mechanicDTO) {
        mechanicService.create(mechanicDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
//TODO add exception handler
    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> getMechanic(@PathVariable Integer id) throws NotFoundException {
        MechanicDTO mechanicDTO = mechanicService.get(id);
        return ResponseEntity.ok(mechanicDTO);
    }
}
