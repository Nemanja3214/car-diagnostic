package com.ftn.sbnz.model.models;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class ElectricCar extends Car{
    private boolean potentionalBatteryProblem;


    private int percentageBattery;
    private boolean faultCheck;
    @ElementCollection(targetClass = FaultCodes.class)
    private List<FaultCodes> codes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public ElectricCar(Integer id, String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalBatteryProblem, int percentageBattery, boolean faultCheck, List<FaultCodes> codes, Integer id1) {
        super(id, plate, yearOfProduction, km, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalBatteryProblem = potentionalBatteryProblem;
        this.percentageBattery = percentageBattery;
        this.faultCheck = faultCheck;
        this.codes = codes;
        this.id = id1;
    }

    public ElectricCar(boolean potentionalBatteryProblem, int percentageBattery, boolean faultCheck, List<FaultCodes> codes, Integer id) {
        this.potentionalBatteryProblem = potentionalBatteryProblem;
        this.percentageBattery = percentageBattery;
        this.faultCheck = faultCheck;
        this.codes = codes;
        this.id = id;
    }

    public ElectricCar(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalBatteryProblem, int percentageBattery, boolean faultCheck, List<FaultCodes> codes, Integer id) {
        super(plate, yearOfProduction, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalBatteryProblem = potentionalBatteryProblem;
        this.percentageBattery = percentageBattery;
        this.faultCheck = faultCheck;
        this.codes = codes;
        this.id = id;
    }

    public ElectricCar(String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalBatteryProblem, int percentageBattery, boolean faultCheck, List<FaultCodes> codes, Integer id) {
        super(plate, yearOfProduction, km, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalBatteryProblem = potentionalBatteryProblem;
        this.percentageBattery = percentageBattery;
        this.faultCheck = faultCheck;
        this.codes = codes;
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
