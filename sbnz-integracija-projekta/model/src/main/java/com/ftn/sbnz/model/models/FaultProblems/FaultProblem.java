package com.ftn.sbnz.model.models.FaultProblems;

public class FaultProblem {
    private FaultProblemKinds kind;
    protected String carId;



    public String getCarId() {
        return this.carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }


    public FaultProblem(String carId) {
        this.kind = FaultProblemKinds.NONE;
        this.carId = carId;
    }

    public FaultProblem(FaultProblemKinds kind, String carId) {
        this.kind = kind;
        this.carId = carId;
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
