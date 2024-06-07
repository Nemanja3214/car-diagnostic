package com.ftn.sbnz.service.services.interfaces;


import com.ftn.sbnz.service.dtos.users.ClientDTO;

import java.util.List;

public interface IClientService {
    void create(ClientDTO clientDTO);

    ClientDTO get(Integer id);

    List<ClientDTO> getAll();
}
