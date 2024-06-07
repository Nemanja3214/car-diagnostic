package com.ftn.sbnz.service.dtos.breakdown;

import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.service.dtos.car.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateBreakdownDTO {
    private String name;
    private Integer carId;
    List<String> symptoms;
    private boolean engineLamp;
    private boolean codeLamp;
    private boolean isElectric;
}
