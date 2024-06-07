package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.models.Mechanic;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MechanicDTO {
    private String username;
    private String password;

    public static MechanicDTO toDTO(Mechanic mechanic) {
        return new MechanicDTO(mechanic.getUsername(), mechanic.getPassword());
    }
}
