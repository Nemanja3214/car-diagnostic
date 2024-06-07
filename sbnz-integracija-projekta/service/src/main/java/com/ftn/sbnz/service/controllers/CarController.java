package com.ftn.sbnz.service.controllers;


import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.dtos.car.CarRetDTO;
import com.ftn.sbnz.service.dtos.car.CreateElectricCarDTO;
import com.ftn.sbnz.service.dtos.car.CreateGasCarDTO;
import com.ftn.sbnz.service.dtos.car.GasCarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.security.PermitAll;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private ICarService carService;

    @PermitAll
    @PostMapping("/electric")
    public ResponseEntity<?> createElectricCar(@RequestBody CreateElectricCarDTO carDTO) throws NotFoundException {
        carService.createElectric(carDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PermitAll
    @PostMapping("/gas")
    public ResponseEntity<?> createGas(@RequestBody CreateGasCarDTO carDTO) throws NotFoundException {
        carService.createGas(carDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) throws NotFoundException {
        CarDTO carDTO = carService.get(id);
        return ResponseEntity.ok(carDTO);
    }

    // TODO change to mechanic
    @PermitAll
    @GetMapping("client/{id}")
    public ResponseEntity<?> getByClient(@PathVariable Integer id) throws NotFoundException{
        List<CarDTO> cars = carService.getByClient(id);
        return ResponseEntity.ok(cars);
    }

    @PermitAll
    @GetMapping("electric/client/{id}")
    public ResponseEntity<?> getElectricByClient(@PathVariable Integer id) throws NotFoundException{
        List<CarDTO> cars = carService.getElectricByClient(id);
        return ResponseEntity.ok(cars);
    }


    @PermitAll
    @GetMapping
    public ResponseEntity<?> getAll() throws NotFoundException{
        List<CarDTO> cars = carService.getAll();
        return ResponseEntity.ok(cars);
    }

    @PermitAll
    @GetMapping("/all")
    public ResponseEntity<?> getAllRet() throws NotFoundException{
        List<CarRetDTO> cars = carService.getAllRet();
        return ResponseEntity.ok(cars);
    }
    @PermitAll
    @GetMapping("/info/{id}")
    public ResponseEntity<CarRetDTO> getCarInfo(@PathVariable Integer id) throws NotFoundException {
        CarRetDTO carDTO = carService.getRetCar(id);
        return ResponseEntity.ok(carDTO);
    }
}
