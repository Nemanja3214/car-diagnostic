package com.ftn.sbnz.model.models.FaultProblems;

public class FaultProblem {
    private FaultProblemKinds kind;
    protected int breakdownId;



    public int getBreakdownId() {
        return this.breakdownId;
    }

    public void setBreakdownId(int breakdownId) {
        this.breakdownId = breakdownId;
    }



    public FaultProblem(int breakdownId) {
        this.kind = FaultProblemKinds.NONE;
        this.breakdownId = breakdownId;
    }

    public FaultProblem(FaultProblemKinds kind, int breakdownId) {
        this.kind = kind;
        this.breakdownId = breakdownId;
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
