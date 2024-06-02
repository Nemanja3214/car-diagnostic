package com.ftn.sbnz.service.dtos.car;

import com.ftn.sbnz.model.models.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private Integer id;
    private String plate;
    private int yearOfProduction;
    private double km;
    private Integer ownerId;
    private Integer carModelId;
//    private List<Lamp> lamps;

    public static CarDTO toDTO(Car car) {
        return new CarDTO(car.getId(), car.getPlate(), car.getYearOfProduction(), car.getKm(), car.getOwner().getId(), car.getModel().getId());
    }
}
