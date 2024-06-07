package com.ftn.sbnz.model.models;

public enum LampKind {
    ENGINE("Engine", true);
    
    private final String stringValue;
    private final boolean show;

    LampKind(String stringValue, boolean show) {
        this.stringValue = stringValue;
        this.show = show;
    }

    public boolean isShow(){
        return show;
    }

    public static LampKind fromString(String text) {
        for (LampKind symptom : LampKind.values()) {
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
