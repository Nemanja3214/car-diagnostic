package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Client;
import com.ftn.sbnz.service.dtos.car.CarDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByOwner(Client client);
}
