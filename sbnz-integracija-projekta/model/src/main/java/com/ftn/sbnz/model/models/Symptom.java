package com.ftn.sbnz.model.models;

import javax.persistence.Entity;
import javax.xml.crypto.KeySelector.Purpose;

public enum Symptom {
    HEADLIGHTS_ON("Headlights are on", true, SymptomPurpose.GAS),
    HEADLIGHTS_FLUCTUATE("Headlights fluctuate", true, SymptomPurpose.GAS),
    NO_START("Car is not starting", true, SymptomPurpose.GAS),
    START("Car is starting", true, SymptomPurpose.GAS),
    CRANKING("Cranking but no starting", true, SymptomPurpose.GAS),
    PERIODICALLY_CRANKING("Periodicaly cranking", true, SymptomPurpose.GAS),
    EMPTY_TANK("Empty tank", true, SymptomPurpose.GAS),
    NOT_EMPTY_TANK("Tank is not empty", true, SymptomPurpose.GAS),
    UNCERTAIN_AMOUNT_OF_GAS("Ammount of gas is not known", true, SymptomPurpose.GAS),
    FLOODED("Car is flooded", true, SymptomPurpose.GAS),
    FUEL_SCENT("Fuel scent", true, SymptomPurpose.GAS),
    PERIODICALLY_FUEL_SCENT("Periodical fuel scent", true, SymptomPurpose.GAS),
    FLAT_TIRE("Tire is flat", true, SymptomPurpose.BOTH),
    DAMAGED_TIRE("Tire is damaged", true, SymptomPurpose.BOTH),
    TIRE_VIBRATING("Tire is vibrating", true, SymptomPurpose.BOTH),
    DIFFICULT_STEERING("Difficuties with steering", true, SymptomPurpose.BOTH),
    PULLING_TO_SIDE("Car is pulling to side", true, SymptomPurpose.BOTH),
    WEIRD_NOISE_ACCELERATION("Weird noice while acceleration", true, SymptomPurpose.GAS),
    HIGH_ENGINE_TEMP("High engine temperature", true, SymptomPurpose.GAS),
    WHITE_SMOKE("White smoke coming out", true, SymptomPurpose.GAS),
    LOW_COOLING_LIQUID("Low cooling liquid", true, SymptomPurpose.GAS),
    UNUSUAL_NOISE("Unusual noise coming out", true, SymptomPurpose.BOTH),
    HESITATION("Hesitation", true, SymptomPurpose.BOTH),
    JERKING("Jerking", true, SymptomPurpose.BOTH),
      OBD("OBD lamp", false, SymptomPurpose.ELECTRIC),

   ELECTRICAL_CODE_A("", false, SymptomPurpose.ELECTRIC),
    ELECTRICAL_CODE_B("", false, SymptomPurpose.ELECTRIC),
    ELECTRICAL_CODE_C("", false, SymptomPurpose.ELECTRIC),
    ELECTRICAL_CODE_D("", false, SymptomPurpose.ELECTRIC);

    private final String stringValue;
    private final boolean show;
    private final SymptomPurpose purpose;

    public boolean isShow(){
        return show;
    }

    public static Symptom fromString(String text) {
        for (Symptom symptom : Symptom.values()) {
            if (symptom.stringValue.equalsIgnoreCase(text)) {
                return symptom;
            }
        }
        return null; // Or throw an exception if the string doesn't match any enum constant
    }

    Symptom(String stringValue, boolean show, SymptomPurpose purpose) {
        this.stringValue = stringValue;
        this.show = show;
        this.purpose = purpose;
    }

    public String getStringValue() {
        return stringValue;
    }

     public SymptomPurpose getPurpose() {
        return purpose;
    }
}
