package com.ftn.sbnz.service.services.interfaces;


import com.ftn.sbnz.service.dtos.MechanicDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;

public interface IMechanicService {
    void create(MechanicDTO mechanicDTO);

    MechanicDTO get(Integer id) throws NotFoundException;
}
