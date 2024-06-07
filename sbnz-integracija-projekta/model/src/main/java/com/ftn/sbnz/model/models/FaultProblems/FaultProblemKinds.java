package com.ftn.sbnz.model.models.FaultProblems;

public enum FaultProblemKinds {
    POWERTRAIN("Powertrain", true),
    AUXILIARY("Auciliary", true),
    REGENERATIVE_BREAKING("Regenerative breaking", true),
    NONE("None", true);
    
    private final String stringValue;
    private final boolean show;

    FaultProblemKinds(String stringValue, boolean show) {
        this.stringValue = stringValue;
        this.show = show;
    }
  public boolean isShow(){
        return show;
    }

    public static FaultProblemKinds fromString(String text) {
        for (FaultProblemKinds symptom : FaultProblemKinds.values()) {
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
