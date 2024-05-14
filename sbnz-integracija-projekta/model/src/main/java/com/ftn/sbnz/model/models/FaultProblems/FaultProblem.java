package com.ftn.sbnz.model.models.FaultProblems;

public class FaultProblem {
    private FaultProblemKinds kind;


    public FaultProblem() {
        this.kind = FaultProblemKinds.NONE;
    }

    public FaultProblem(FaultProblemKinds kind) {
        this.kind = kind;
    }

    public FaultProblemKinds getKind() {
        return this.kind;
    }

    public void setKind(FaultProblemKinds kind) {
        this.kind = kind;
    }

    public FaultProblem kind(FaultProblemKinds kind) {
        setKind(kind);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " kind='" + getKind() + "'" +
            "}";
    }

}
