package com.ftn.sbnz.model.models;

import javax.persistence.Entity;

public enum Symptom {
    HEADLIGHTS_ON("Headlights are on", true),
    HEADLIGHTS_FLUCTUATE("Headlights fluctuate", true),
    NO_START("Car is not starting", true),
    START("Car is starting", true),
    CRANKING("Cranking but no starting", true),
    PERIODICALLY_CRANKING("Periodicaly cranking", true),
    EMPTY_TANK("Empty tank", true),
    NOT_EMPTY_TANK("Tank is not empty", true),
    UNCERTAIN_AMOUNT_OF_GAS("Ammount of gas is not known", true),
    FLOODED("Car is flooded", true),
    FUEL_SCENT("Fuel scent", true),
    PERIODICALLY_FUEL_SCENT("Periodical fuel scent", true),
    FLAT_TIRE("Tire is flat", true),
    DAMAGED_TIRE("Tire is damaged", true),
    TIRE_VIBRATING("Tire is vibrating", true),
    DIFFICULT_STEERING("Difficuties with steering", true),
    PULLING_TO_SIDE("Car is pulling to side", true),
    WEIRD_NOISE_ACCELERATION("Weird noice while acceleration", true),
    HIGH_ENGINE_TEMP("High engine temperature", true),
    WHITE_SMOKE("White smoke coming out", true),
    LOW_COOLING_LIQUID("Low cooling liquid", true),
    UNUSUAL_NOISE("Unusual noise coming out", true),
    HESITATION("Hesitation", true),
    JERKING("Jerking", true),

   ELECTRICAL_CODE_A("", false),
    ELECTRICAL_CODE_B("", false),
    ELECTRICAL_CODE_C("", false),
    ELECTRICAL_CODE_D("", false);

    private final String stringValue;
    private final boolean show;

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

    Symptom(String stringValue, boolean show) {
        this.stringValue = stringValue;
        this.show = show;
    }

    public String getStringValue() {
        return stringValue;
    }
}
