package com.ftn.sbnz.model.models;



public class CarModel {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

    public CarModel() {}

    public CarModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
