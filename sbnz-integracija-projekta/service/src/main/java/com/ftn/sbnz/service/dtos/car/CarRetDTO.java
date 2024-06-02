package com.ftn.sbnz.service.dtos.car;

import com.ftn.sbnz.model.models.Car;

public class CarRetDTO {
    private Integer id;
    private String plate;
    private int yearOfProduction;
    private double km;

    private String owner;

    private String model;

    public CarRetDTO(Car car) {
        this.id = car.getId();
        this.plate = car.getPlate();
        this.km = car.getKm();
        this.yearOfProduction = car.getYearOfProduction();
        this.owner = car.getOwner().getName() + " " + car.getOwner().getLastName();
        this.model = car.getModel().getName();
    }
}
