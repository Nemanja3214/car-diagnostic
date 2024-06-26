package com.ftn.sbnz.model.models;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
public class Car {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     private boolean ruleFinished;

    public boolean isRuleFinished() {
        return ruleFinished;
    }

    public void setRuleFinished(boolean ruleFinished) {
        this.ruleFinished = ruleFinished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car(Integer id, String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        this.id = id;
        this.plate = plate;
        this.yearOfProduction = yearOfProduction;
        this.km = km;
        this.potentionalEngineIssue = potentionalEngineIssue;
        this.owner = owner;
        this.model = model;
        this.lamps = lamps;
        this.repairments = repairments;
    }

    protected String plate;
    protected int yearOfProduction;
    protected double km;
    protected boolean potentionalEngineIssue;
    @ManyToOne(cascade = CascadeType.ALL)
    protected Client owner;
    @ManyToOne
    protected CarModel model;
    @OneToMany
    protected List<Lamp> lamps;
    @OneToMany
    protected List<Repairment> repairments;
    protected boolean isElectric;

    public Car() {
        repairments = new ArrayList<>();
    }

    public Car(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        this.plate = plate;
        this.yearOfProduction = yearOfProduction;
        this.potentionalEngineIssue = potentionalEngineIssue;
        this.owner = owner;
        this.model = model;
        this.lamps = lamps;
        this.repairments = repairments;
    }

    public Car(String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        this.plate = plate;
        this.yearOfProduction = yearOfProduction;
        this.km = km;
        this.potentionalEngineIssue = potentionalEngineIssue;
        this.owner = owner;
        this.model = model;
        this.lamps = lamps;
        this.repairments = repairments;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public List<Repairment> getRepairments() {
        return repairments;
    }

    public void setRepairments(List<Repairment> repairments) {
        this.repairments = repairments;
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

    public boolean getPotentionalEngineIssue() {
        return this.potentionalEngineIssue;
    }


    public boolean isIsElectric() {
        return this.isElectric;
    }

    public boolean getIsElectric() {
        return this.isElectric;
    }

    public void setIsElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }


    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isPotentionalEngineIssue() {
        return potentionalEngineIssue;
    }

    public void setPotentionalEngineIssue(boolean potentionalEngineIssue) {
        this.potentionalEngineIssue = potentionalEngineIssue;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public void setLamps(List<Lamp> lamps) {
        this.lamps = lamps;
    }
}
