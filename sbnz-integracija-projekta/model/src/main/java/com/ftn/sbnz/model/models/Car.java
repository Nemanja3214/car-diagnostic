package com.ftn.sbnz.model.models;



import java.util.List;

public class Car {
    private String plate;
    private int yearOfProduction;
    private boolean potentionalEngineIssue;
    private boolean potentionalTurbineIssue;
    private boolean potentionalCoolingLeakage;

    private Client owner;

    private CarModel model;
    private List<Lamp> lamps;
    private List<Repairment> repairments;

    public Car() {}

    public Car(String plate, int yearOfProduction, boolean potentionalEngineIssue, boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        this.plate = plate;
        this.yearOfProduction = yearOfProduction;
        this.potentionalEngineIssue = potentionalEngineIssue;
        this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
        this.owner = owner;
        this.model = model;
        this.lamps = lamps;
        this.repairments = repairments;
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

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isPotentionalEngineIssue() {
        return potentionalEngineIssue;
    }

    public void setPotentionalEngineIssue(boolean potentionalEngineIssue) {
        this.potentionalEngineIssue = potentionalEngineIssue;
    }

    public boolean isPotentionalTurbineIssue() {
        return potentionalTurbineIssue;
    }

    public void setPotentionalTurbineIssue(boolean potentionalTurbineIssue) {
        this.potentionalTurbineIssue = potentionalTurbineIssue;
    }

    public boolean isPotentionalCoolingLeakage() {
        return potentionalCoolingLeakage;
    }

    public void setPotentionalCoolingLeakage(boolean potentionalCoolingLeakage) {
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
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
