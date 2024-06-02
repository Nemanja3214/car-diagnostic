package com.ftn.sbnz.service.controllers;


import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.service.dtos.car.GasCarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@CrossOrigin
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private ICarService carService;

    @PermitAll
    @PostMapping("/electric")
    public ResponseEntity<?> createElectricCar(@RequestBody ElectricCarDTO carDTO) throws NotFoundException {
        carService.createElectric(carDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PermitAll
    @PostMapping("/gas")
    public ResponseEntity<?> createGas(@RequestBody GasCarDTO carDTO) throws NotFoundException {
        carService.createGas(carDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //TODO add exception handler
    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) throws NotFoundException {
        CarDTO carDTO = carService.get(id);
        return ResponseEntity.ok(carDTO);
    }

    @PermitAll
    @GetMapping("/info/{id}")
    public ResponseEntity<?> getCarInfo(@PathVariable Integer id) throws NotFoundException {
        CarDTO carDTO = carService.get(id);
        return ResponseEntity.ok(carDTO);
    }
}
