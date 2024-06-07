package com.ftn.sbnz.service.dtos.repairment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckServiceDTO {
    private Integer carId;
    private double km;
}
