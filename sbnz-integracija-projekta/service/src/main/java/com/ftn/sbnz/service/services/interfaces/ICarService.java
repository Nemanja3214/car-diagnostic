package com.ftn.sbnz.service.services.interfaces;


import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.service.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.service.dtos.car.GasCarDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;

public interface ICarService {
    void createElectric(ElectricCarDTO carDTO) throws NotFoundException;

    CarDTO get(Integer id);

    void createGas(GasCarDTO carDTO) throws NotFoundException;
}
