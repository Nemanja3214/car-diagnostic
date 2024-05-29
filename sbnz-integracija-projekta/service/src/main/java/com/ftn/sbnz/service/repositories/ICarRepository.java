package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car, Integer> {
}
