package com.ftn.sbnz.model.models;



import java.util.ArrayList;
import java.util.List;

public class ElectricCar extends Car{
    private boolean potentionalBatteryProblem;


    private int percentageBattery;
    private boolean faultCheck;
     private List<FaultCodes> codes;

    public void addCode(FaultCodes code){
        this.codes.add(code);
    }

    public List<FaultCodes> getCodes() {
        return this.codes;
    }

    public void setCodes(List<FaultCodes> codes) {
        this.codes = codes;
    }

    public boolean isFaultCheck() {
        return this.faultCheck;
    }

    public boolean getFaultCheck() {
        return this.faultCheck;
    }

    public void setFaultCheck(boolean faultCheck) {
        this.faultCheck = faultCheck;
    }


    public ElectricCar(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments) {
        super(plate, yearOfProduction, potentionalEngineIssue, owner, model, lamps, repairments);
       this.codes = new ArrayList<FaultCodes>();
    }


    public ElectricCar() {
         this.codes = new ArrayList<FaultCodes>();
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
