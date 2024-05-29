package com.ftn.sbnz.services.interfaces;


import com.ftn.sbnz.dtos.car.CarDTO;
import com.ftn.sbnz.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.dtos.car.GasCarDTO;
import com.ftn.sbnz.exceptions.NotFoundException;

public interface ICarService {
    void createElectric(ElectricCarDTO carDTO) throws NotFoundException;

    CarDTO get(Integer id);

    void createGas(GasCarDTO carDTO) throws NotFoundException;
}
