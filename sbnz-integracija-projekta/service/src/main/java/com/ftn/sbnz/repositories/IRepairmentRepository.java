package com.ftn.sbnz.repositories;

import com.ftn.sbnz.model.models.Repairment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepairmentRepository extends JpaRepository<Repairment, Integer> {
}
