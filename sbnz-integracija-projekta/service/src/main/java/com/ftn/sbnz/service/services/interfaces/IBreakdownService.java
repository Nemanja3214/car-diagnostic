package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.breakdown.BreakdownDTO;
import com.ftn.sbnz.service.dtos.breakdown.CreateBreakdownDTO;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;

import java.util.List;

public interface IBreakdownService {
    List<BreakdownDTO> getAll();

    List<RepairmentDTO> create(CreateBreakdownDTO dto) throws NotFoundException;

    BreakdownDTO get(Integer id);

    List<String> getSymptoms();
}
