package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Repairment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepairmentRepository extends JpaRepository<Repairment, Integer> {

     @Query("SELECT r FROM Repairment r WHERE r.breakdown.car.id = :carId")
     List<Repairment> findAllByCarId(Integer carId);

}
