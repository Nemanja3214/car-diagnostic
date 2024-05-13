package com.ftn.sbnz.model.models;


import java.util.List;

public class Breakdown {

    private String name;

    public Breakdown(String name, List<Symptom> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
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

    private List<Symptom> symptoms;

    public Breakdown() {}


}
