package com.ftn.sbnz.dtos.car;

import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Lamp;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CarDTO {
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
//    private List<Lamp> lamps;

    public static CarDTO toDTO(Car car) {
        return new CarDTO(car.getPlate(), car.getYearOfProduction(), car.getKm(), car.getOwner().getId(), car.getModel().getId());
    }
}
