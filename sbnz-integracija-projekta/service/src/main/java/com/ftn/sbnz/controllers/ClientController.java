package com.ftn.sbnz.controllers;


import com.ftn.sbnz.dtos.car.CarDTO;
import com.ftn.sbnz.dtos.car.ElectricCarDTO;
import com.ftn.sbnz.dtos.car.GasCarDTO;
import com.ftn.sbnz.dtos.users.ClientDTO;
import com.ftn.sbnz.exceptions.NotFoundException;
import com.ftn.sbnz.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @PermitAll
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientDTO clientDTO) throws NotFoundException {
        clientService.create(clientDTO);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //TODO add exception handler
    @PermitAll
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) throws NotFoundException {
        ClientDTO clientDTO = clientService.get(id);
        return ResponseEntity.ok(clientDTO);
    }

    @PermitAll
    @GetMapping
    public ResponseEntity<?> getAll() throws NotFoundException {
        List<ClientDTO> clientDTOs = clientService.getAll();
        return ResponseEntity.ok(clientDTOs);
    }
}
