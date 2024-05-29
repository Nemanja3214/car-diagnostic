package com.ftn.sbnz.repositories;

import com.ftn.sbnz.model.models.battery.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBatteryRepository extends JpaRepository<Battery, Integer> {
}
