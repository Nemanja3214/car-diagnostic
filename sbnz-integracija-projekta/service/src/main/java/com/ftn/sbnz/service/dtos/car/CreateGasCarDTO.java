package com.ftn.sbnz.service.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGasCarDTO {
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
    
}
