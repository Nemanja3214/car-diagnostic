package com.ftn.sbnz.controllers;


import com.ftn.sbnz.dtos.MechanicDTO;
import com.ftn.sbnz.services.interfaces.IMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import javax.annotation.security.PermitAll;

@CrossOrigin
@RestController
@RequestMapping("/api/mechanic")
public class MechanicController {
    @Autowired
    IMechanicService mechanicService;

//    @PermitAll
//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody MechanicDTO mechanicDTO) {
//
//    }
}
