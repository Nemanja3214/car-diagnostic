package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
}
