package com.ftn.sbnz.service.controllers;


import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.models.CarModel;
import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.CarModelService;

@CrossOrigin
@RestController
@RequestMapping("/api/carModel")
public class CarModelController {
    @Autowired
    private CarModelService carModelService;


      @PermitAll
    @GetMapping
    public ResponseEntity<?> getAll() throws NotFoundException{
        List<CarModel> models = carModelService.getAll();
        return ResponseEntity.ok(models);
    }
}
