package com.ftn.sbnz.service.dtos.breakdown;

import java.util.List;

import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryCheckDTO {
    private List<RepairmentDTO> repairments;
    private List<CurrentReadingDTO> currentReadings;
}
