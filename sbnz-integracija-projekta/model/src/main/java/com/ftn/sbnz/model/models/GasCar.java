package com.ftn.sbnz.model.models;

import java.util.List;

public class GasCar extends Car{
    private boolean potentionalTurbineIssue;
    private boolean potentionalCoolingLeakage;

    public GasCar(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage) {
        super(plate, yearOfProduction, potentionalEngineIssue, owner, model, lamps, repairments);
          this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
    }


    public GasCar() {
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
    
}
