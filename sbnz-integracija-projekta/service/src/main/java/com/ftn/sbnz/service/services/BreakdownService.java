package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.IBreakdownRepository;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreakdownService implements IBreakdownService {
    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private IBreakdownRepository breakdownRepository;

    @Override
    public List<BreakdownDTO> getAll() {
        return breakdownRepository.findAll().stream().map(BreakdownDTO::toDTO).collect(Collectors.toList());
    }


    @Override
    public void create(CreateBreakdownDTO dto) throws NotFoundException {
        Breakdown breakdown = new Breakdown();

        if(!carRepository.existsById(dto.getCarId()))
            throw new NotFoundException();

        breakdown.setName(dto.getName());
        breakdown.setSymptoms(dto.getSymptoms());

        breakdownRepository.save(breakdown);

    }

    @Override
    public BreakdownDTO get(Integer id) {
        return BreakdownDTO.toDTO(breakdownRepository.findById(id).orElse(null));
    }
}