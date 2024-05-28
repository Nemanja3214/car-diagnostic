package com.ftn.sbnz.model.models.battery;

public class Battery {
    private BatteryStates state;
    private long id;

    private double nominalMaxCharge;
    private double nominalMaxVoltage;

    public double getNominalMaxVoltage() {
        return this.nominalMaxVoltage;
    }

    public void setNominalMaxVoltage(double nominalMaxVoltage) {
        this.nominalMaxVoltage = nominalMaxVoltage;
    }


    public double getNominalMaxCharge() {
        return this.nominalMaxCharge;
    }

    public void setNominalMaxCharge(double nominalMaxCharge, double nominalMaxVoltage) {
        this.nominalMaxCharge = nominalMaxCharge;
        this.nominalMaxVoltage = nominalMaxVoltage;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Battery(long id) {
        this.id=  id;
        this.state = BatteryStates.INITIAL;
    }


    public BatteryStates getState() {
        return this.state;
    }

    public void setState(BatteryStates state) {
        this.state = state;
    }

    
}