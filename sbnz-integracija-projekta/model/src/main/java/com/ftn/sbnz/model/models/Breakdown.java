package com.ftn.sbnz.model.models;


import java.util.List;

public class Breakdown {

    private Integer id;

    public Breakdown(Integer id, String name, Car car, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.symptoms = symptoms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private Car car;
    private long id;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Breakdown(String name, List<Symptom> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public Breakdown(String name, List<Symptom> symptoms, Car car) {
        this.name = name;
        this.symptoms = symptoms;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Car getCar(){
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }

    private List<Symptom> symptoms;

    public Breakdown() {}


}
