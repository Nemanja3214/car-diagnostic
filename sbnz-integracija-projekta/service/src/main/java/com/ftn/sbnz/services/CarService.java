package com.ftn.sbnz.services;


import com.ftn.sbnz.dtos.car.CarDTO;
import com.ftn.sbnz.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.dtos.car.GasCarDTO;
import com.ftn.sbnz.exceptions.NotFoundException;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.GasCar;
import com.ftn.sbnz.repositories.ICarModelRepository;
import com.ftn.sbnz.repositories.ICarRepository;
import com.ftn.sbnz.repositories.IClientRepository;
import com.ftn.sbnz.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarModelRepository carModelRepository;

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    IClientRepository clientRepository;

    @Override
    public void createElectric(ElectricCarDTO carDTO) throws NotFoundException {
        ElectricCar car = new ElectricCar();
        car.setKm(car.getKm());

        if(carModelRepository.existsById(carDTO.getCarModelId()))
            throw new NotFoundException();

        car.setModel(carModelRepository.findById(carDTO.getCarModelId()).get());

        car.setOwner(clientRepository.findById(carDTO.getOwnerId()).get());

        car.setPlate(carDTO.getPlate());
        car.setYearOfProduction(carDTO.getYearOfProduction());
//        TODO lamps
        car.setRepairments(new ArrayList<>());

        carRepository.save(car);

    }

    @Override
    public CarDTO get(Integer id) {
        return CarDTO.toDTO(carRepository.findById(id).get());
    }

    @Override
    public void createGas(GasCarDTO carDTO) throws NotFoundException {
        GasCar car = new GasCar();
        car.setKm(car.getKm());

        if(carModelRepository.existsById(carDTO.getCarModelId()))
            throw new NotFoundException();

        car.setModel(carModelRepository.findById(carDTO.getCarModelId()).get());

        car.setOwner(clientRepository.findById(carDTO.getOwnerId()).get());

        car.setPlate(carDTO.getPlate());
        car.setYearOfProduction(carDTO.getYearOfProduction());
//        TODO lamps
        car.setRepairments(new ArrayList<>());

        carRepository.save(car);
    }
}
