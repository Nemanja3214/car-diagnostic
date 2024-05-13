package com.ftn.sbnz.model.models;



import java.util.List;

public class ElectricCar extends Car{
    private boolean potentionalBatteryProblem;
    private int percentageBattery;


    public ElectricCar(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        super(plate, yearOfProduction, potentionalEngineIssue, owner, model, lamps, repairments);
    }


    public ElectricCar() {
    }

   public boolean isPotentionalBatteryProblem() {
        return potentionalBatteryProblem;
    }

    public void setPotentionalBatteryProblem(boolean potentionalBatteryProblem) {
        this.potentionalBatteryProblem = potentionalBatteryProblem;
    }


    public boolean getPotentionalBatteryProblem() {
        return this.potentionalBatteryProblem;
    }


    public int getPercentageBattery() {
        return this.percentageBattery;
    }

    public void setPercentageBattery(int percentageBattery) {
        this.percentageBattery = percentageBattery;
    }

}
