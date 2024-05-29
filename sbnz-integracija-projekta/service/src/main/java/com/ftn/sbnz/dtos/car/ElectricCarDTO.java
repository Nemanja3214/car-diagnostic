package com.ftn.sbnz.dtos.car;

import com.ftn.sbnz.model.models.Lamp;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ElectricCarDTO {
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
    private List<Lamp> lamps;
}
