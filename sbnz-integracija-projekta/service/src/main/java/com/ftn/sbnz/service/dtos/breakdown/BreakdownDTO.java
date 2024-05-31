package com.ftn.sbnz.service.dtos.breakdown;


import com.ftn.sbnz.service.dtos.car.CarDTO;
import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BreakdownDTO {
        private String name;
        private CarDTO car;
        List<Symptom> symptoms;

    public static BreakdownDTO toDTO(Breakdown a) {
        if(a == null)
            return null;
        BreakdownDTO dto = new BreakdownDTO();
        dto.setCar(CarDTO.toDTO(a.getCar()));
        dto.setSymptoms(a.getSymptoms());
        dto.setName(a.getName());
        return dto;
    }
}
