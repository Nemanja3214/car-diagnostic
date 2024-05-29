package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.service.dtos.BreakdownDTO;

import java.util.List;

public interface IBreakdownService {
    List<BreakdownDTO> getAll();
}
