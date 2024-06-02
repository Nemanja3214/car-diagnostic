package com.ftn.sbnz.service.services;


import com.ftn.sbnz.model.models.CarModel;
import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.repositories.ICarModelRepository;
import com.ftn.sbnz.service.services.interfaces.ICarModelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarModelService implements ICarModelService {
    @Autowired
    ICarModelRepository repository;

    public List<CarModel> getAll() {
        return repository.findAll();
    }
}
