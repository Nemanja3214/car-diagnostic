package com.ftn.sbnz.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ftn.sbnz.model.models.Client;
public interface IClientRepository extends JpaRepository<Client, Integer> {
}
