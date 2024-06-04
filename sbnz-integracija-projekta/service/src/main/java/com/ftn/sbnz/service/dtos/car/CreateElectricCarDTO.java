package com.ftn.sbnz.service.dtos.car;

import java.util.List;

import com.ftn.sbnz.model.models.Lamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateElectricCarDTO {
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
    private double nominalMaxCharge;
    private double nominalMaxVoltage;
}
