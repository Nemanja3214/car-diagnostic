package com.ftn.sbnz.service.controllers;


import com.ftn.sbnz.service.dtos.MechanicDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.IMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.annotation.security.PermitAll;

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
