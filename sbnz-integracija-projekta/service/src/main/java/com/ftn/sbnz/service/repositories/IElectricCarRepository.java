package com.ftn.sbnz.service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.sbnz.model.models.CarModel;
import com.ftn.sbnz.model.models.Client;
import com.ftn.sbnz.model.models.ElectricCar;

public interface IElectricCarRepository extends JpaRepository<ElectricCar, Integer>{

    List<ElectricCar> findAllByOwner(Client client);
    
}
