package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Mechanic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMechanicRepository extends JpaRepository<Mechanic, Integer> {

    Optional<Mechanic> findByUsername(String username);
    public Optional<Mechanic> getUserByUsername(String username);
}
