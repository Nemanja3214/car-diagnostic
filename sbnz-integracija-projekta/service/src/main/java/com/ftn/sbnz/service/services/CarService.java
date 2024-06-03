package com.ftn.sbnz.service.services;


import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.dtos.car.CarRetDTO;
import com.ftn.sbnz.service.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.service.dtos.car.GasCarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Client;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.GasCar;
import com.ftn.sbnz.service.repositories.ICarModelRepository;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.repositories.IClientRepository;
import com.ftn.sbnz.service.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

//         if(carModelRepository.existsById(carDTO.getCarModelId()))
//             throw new NotFoundException();

//         car.setModel(carModelRepository.findById(carDTO.getCarModelId()).get());

//         car.setOwner(clientRepository.findById(carDTO.getOwnerId()).get());

//         car.setPlate(carDTO.getPlate());
//         car.setYearOfProduction(carDTO.getYearOfProduction());
// //        TODO lamps
//         car.setRepairments(new ArrayList<>());

        carRepository.save(car);

    }

    @Override
    public CarDTO get(Integer id) {
        return CarDTO.toDTO(carRepository.findById(id).get());
    }

    @Override
    public CarRetDTO getRetCar(Integer id) {
        return new CarRetDTO(carRepository.findById(id).get());
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

    @Override
    public List<CarDTO> getByClient(Integer clientId) throws NotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(NotFoundException::new);
        return this.carRepository.findAllByOwner(client).stream().map(CarDTO::toDTO).toList();
        // return null;
    }

    @Override
    public List<CarDTO> getAll() {
        return carRepository.findAll().stream().map(CarDTO::toDTO).toList();
        // return null;
    }
}
