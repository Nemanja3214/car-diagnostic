package com.ftn.sbnz.service.services;


import com.ftn.sbnz.service.dtos.MechanicDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.model.models.Mechanic;
import com.ftn.sbnz.service.repositories.IMechanicRepository;
import com.ftn.sbnz.service.services.interfaces.IMechanicService;
import org.springframework.stereotype.Service;

@Service
public class MechanicService implements IMechanicService {
    private IMechanicRepository mechanicRepository;
    @Override
    public void create(MechanicDTO mechanicDTO) {
        Mechanic mechanic = new Mechanic(mechanicDTO.getUsername(), mechanicDTO.getPassword());
        mechanicRepository.save(mechanic);
    }

    @Override
    public MechanicDTO get(Integer id) throws NotFoundException {
        Mechanic mechanic = mechanicRepository.findById(id).orElse(null);
        if(mechanic == null)
            throw new NotFoundException();
        return MechanicDTO.toDTO(mechanic);
    }
}
