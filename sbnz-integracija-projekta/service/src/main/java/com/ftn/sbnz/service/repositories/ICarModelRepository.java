package com.ftn.sbnz.service.repositories;


import com.ftn.sbnz.model.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarModelRepository extends JpaRepository<CarModel, Integer> {
}
