package com.ftn.sbnz.service.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GasCarDTO {
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
}
