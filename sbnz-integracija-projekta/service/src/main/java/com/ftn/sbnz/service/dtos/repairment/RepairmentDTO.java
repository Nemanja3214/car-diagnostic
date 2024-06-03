package com.ftn.sbnz.service.dtos.repairment;

import com.ftn.sbnz.model.models.Repairment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RepairmentDTO {
    private Integer id;
    private String action;
    private double price;
    private double discount;

    private String mechanic;

    public RepairmentDTO(Repairment rep) {
        this.id = rep.getId();
        this.discount = rep.getDiscount().getPercent();
        this.mechanic = rep.getMechanic().getUsername();
        this.action = rep.getAction();
        this.price = rep.getPrice();
    }
}
