package com.ftn.sbnz.model.models;


import java.util.List;

public class Breakdown {

    private String name;
    private Car car;

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
