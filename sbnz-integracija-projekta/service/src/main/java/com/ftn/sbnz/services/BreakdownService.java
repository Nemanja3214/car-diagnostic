package com.ftn.sbnz.services;

import com.ftn.sbnz.dtos.BreakdownDTO;
import com.ftn.sbnz.repositories.IBreakdownRepository;
import com.ftn.sbnz.services.interfaces.IBreakdownService;
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
