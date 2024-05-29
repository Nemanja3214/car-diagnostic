package com.ftn.sbnz.services.interfaces;


import com.ftn.sbnz.dtos.MechanicDTO;
import com.ftn.sbnz.exceptions.NotFoundException;

public interface IMechanicService {
    void create(MechanicDTO mechanicDTO);

    MechanicDTO get(Integer id) throws NotFoundException;
}
