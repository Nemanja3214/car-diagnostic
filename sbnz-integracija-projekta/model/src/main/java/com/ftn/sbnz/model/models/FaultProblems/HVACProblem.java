package com.ftn.sbnz.model.models.FaultProblems;
import java.util.Objects;

public class HVACProblem extends AuxiliaryProblem{
    private HVACProblemKinds hvacKind;

    public HVACProblem(int breakdownId) {
        super(breakdownId);
    }

    public HVACProblem(HVACProblemKinds hvacKind, int breakdownId) {
        this(breakdownId);
        this.hvacKind = hvacKind;
    }

    public HVACProblemKinds getHvacKind() {
        return this.hvacKind;
    }

    public void setHvacKind(HVACProblemKinds hvacKind) {
        this.hvacKind = hvacKind;
    }

    public HVACProblem hvacKind(HVACProblemKinds hvacKind) {
        setHvacKind(hvacKind);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " hvacKind='" + getHvacKind() + "'" +
            "}";
    }

    
    
}
