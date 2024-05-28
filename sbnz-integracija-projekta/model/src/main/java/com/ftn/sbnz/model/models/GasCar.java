package com.ftn.sbnz.model.models;

import java.util.List;

public class GasCar extends Car{
    private boolean potentionalTurbineIssue;
    private boolean potentionalCoolingLeakage;
    private Integer id;

    public GasCar(Integer id, String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage, Integer id1) {
        super(id, plate, yearOfProduction, km, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
        this.id = id1;
    }

    public GasCar(boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage, Integer id) {
        this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
        this.id = id;
    }

    public GasCar(String plate, int yearOfProduction, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage, Integer id) {
        super(plate, yearOfProduction, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
        this.id = id;
    }

    public GasCar(String plate, int yearOfProduction, double km, boolean potentionalEngineIssue, Client owner, CarModel model, List<Lamp> lamps, List<Repairment> repairments, boolean potentionalTurbineIssue, boolean potentionalCoolingLeakage, Integer id) {
        super(plate, yearOfProduction, km, potentionalEngineIssue, owner, model, lamps, repairments);
        this.potentionalTurbineIssue = potentionalTurbineIssue;
        this.potentionalCoolingLeakage = potentionalCoolingLeakage;
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
