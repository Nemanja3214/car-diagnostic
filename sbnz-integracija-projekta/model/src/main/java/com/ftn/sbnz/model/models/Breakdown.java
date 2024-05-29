package com.ftn.sbnz.model.models;


import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Breakdown {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
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
    @ElementCollection(targetClass = Symptom.class)
    private List<Symptom> symptoms;

    public Breakdown() {}


}
