package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Breakdown;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBreakdownRepository extends JpaRepository<Breakdown, Integer> {
}
