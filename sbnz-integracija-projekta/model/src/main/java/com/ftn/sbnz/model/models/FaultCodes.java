package com.ftn.sbnz.model.models;

public enum FaultCodes {
    ELECTRICAL_CODE_A("ELectrical code A", true),
    ELECTRICAL_CODE_B("ELectrical code B", true),
    ELECTRICAL_CODE_C("ELectrical code C", true);
    
    private final String stringValue;
    private final boolean show;

    FaultCodes(String stringValue, boolean show) {
        this.stringValue = stringValue;
        this.show = show;
    }
  public boolean isShow(){
        return show;
    }

    public static FaultCodes fromString(String text) {
        for (FaultCodes symptom : FaultCodes.values()) {
            if (symptom.stringValue.equalsIgnoreCase(text)) {
                return symptom;
            }
        }
        return null; // Or throw an exception if the string doesn't match any enum constant
    }

     public String getStringValue() {
        return stringValue;
    }
}
