package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.dtos.BreakdownDTO;
import com.ftn.sbnz.service.repositories.IBreakdownRepository;
import com.ftn.sbnz.service.services.interfaces.IBreakdownService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreakdownService implements IBreakdownService {
    private IBreakdownRepository breakdownRepository;
    @Override
    public List<BreakdownDTO> getAll() {
        return breakdownRepository.findAll().stream().map(BreakdownDTO::toDTO).collect(Collectors.toList());
    }
}
