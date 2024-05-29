package com.ftn.sbnz.services.interfaces;


import com.ftn.sbnz.dtos.users.ClientDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface IClientService {
    void create(ClientDTO clientDTO);

    ClientDTO get(Integer id);

    List<ClientDTO> getAll();
}
