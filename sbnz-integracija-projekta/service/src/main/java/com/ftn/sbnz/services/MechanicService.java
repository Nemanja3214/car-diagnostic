package com.ftn.sbnz.services;


import com.ftn.sbnz.dtos.MechanicDTO;
import com.ftn.sbnz.exceptions.NotFoundException;
import com.ftn.sbnz.model.models.Mechanic;
import com.ftn.sbnz.repositories.IMechanicRepository;
import com.ftn.sbnz.services.interfaces.IMechanicService;
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
