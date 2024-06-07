package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.GasCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGasCarRepository extends JpaRepository<GasCar, Integer> {

}
