package com.ftn.sbnz.services;


import com.ftn.sbnz.dtos.users.ClientDTO;
import com.ftn.sbnz.model.models.Client;
import com.ftn.sbnz.repositories.IClientRepository;
import com.ftn.sbnz.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {
    @Autowired
    IClientRepository clientRepository;
    @Override
    public void create(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setLastName(clientDTO.getLastName());
        clientRepository.save(client);
    }

    @Override
    public ClientDTO get(Integer id) {
        return ClientDTO.toDTO(clientRepository.findById(id).get());
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientRepository.findAll().stream().map(ClientDTO::toDTO).collect(Collectors.toList());
    }
}
