package com.ftn.sbnz.service.dtos.breakdown;

import java.util.Date;

import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentReadingDTO {
     private Date startTime;
       private double value;
       private Long batteryId;
       private double currentSOC;
       private double currentCharge;
 
    public static CurrentReadingDTO toDTO(CurrentReadingEvent reading){
        CurrentReadingDTO dto = new CurrentReadingDTO();
        dto.setStartTime(reading.getStartTime());
        dto.setValue(reading.getValue());
        dto.setBatteryId(reading.getBatteryId());
        dto.setCurrentCharge(reading.getCurrentCharge());
        dto.setCurrentSOC(reading.getCurrentSOC());
        return dto;
    }
}
