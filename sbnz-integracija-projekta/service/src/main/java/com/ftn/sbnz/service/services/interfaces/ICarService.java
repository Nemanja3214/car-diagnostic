package com.ftn.sbnz.service.services.interfaces;


import java.util.List;

import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.dtos.car.CarRetDTO;
import com.ftn.sbnz.service.dtos.car.CreateElectricCarDTO;
import com.ftn.sbnz.service.dtos.car.CreateGasCarDTO;
import com.ftn.sbnz.service.dtos.car.GasCarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;

public interface ICarService {
    void createElectric(CreateElectricCarDTO carDTO) throws NotFoundException;

    CarDTO get(Integer id);

    CarRetDTO getRetCar(Integer id);

    void createGas(CreateGasCarDTO carDTO) throws NotFoundException;

    List<CarDTO> getByClient(Integer clientId) throws NotFoundException;

    List<CarDTO> getAll();

    List<CarDTO> getElectricByClient(Integer clientId) throws NotFoundException;
}
