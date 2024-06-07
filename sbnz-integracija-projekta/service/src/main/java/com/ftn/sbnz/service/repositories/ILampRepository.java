package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Lamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILampRepository extends JpaRepository<Lamp, Integer> {
}
