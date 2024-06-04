package com.ftn.sbnz.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.sbnz.model.models.ElectricCar;

public interface IElectricCarRepository extends JpaRepository<ElectricCar, Integer>{
    
}
