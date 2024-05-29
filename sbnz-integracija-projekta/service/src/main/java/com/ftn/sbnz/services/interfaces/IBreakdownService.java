package com.ftn.sbnz.services.interfaces;

import com.ftn.sbnz.dtos.BreakdownDTO;

import java.util.List;

public interface IBreakdownService {
    List<BreakdownDTO> getAll();
}
