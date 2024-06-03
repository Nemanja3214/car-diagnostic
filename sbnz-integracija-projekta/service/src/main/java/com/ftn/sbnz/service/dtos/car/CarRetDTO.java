package com.ftn.sbnz.service.dtos.car;

import com.ftn.sbnz.model.models.Car;

public class CarRetDTO {
    private Integer id;
    private String plate;
    private int yearOfProduction;
    private double km;

    private String owner;

    private String model;

    public CarRetDTO() {}

    public CarRetDTO(Car car) {
        this.id = car.getId();
        this.plate = car.getPlate();
        this.km = car.getKm();
        this.yearOfProduction = car.getYearOfProduction();
        this.owner = car.getOwner().getName() + " " + car.getOwner().getLastName();
        this.model = car.getModel().getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
