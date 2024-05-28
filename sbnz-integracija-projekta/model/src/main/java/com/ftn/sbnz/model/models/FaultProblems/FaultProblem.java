package com.ftn.sbnz.model.models.FaultProblems;

public class FaultProblem {
    private FaultProblemKinds kind;
    protected long breakdownId;



    public long getBreakdownId() {
        return this.breakdownId;
    }

    public void setBreakdownId(long breakdownId) {
        this.breakdownId = breakdownId;
    }



    public FaultProblem(long breakdownId) {
        this.kind = FaultProblemKinds.NONE;
        this.breakdownId = breakdownId;
    }

    public FaultProblem(FaultProblemKinds kind, long breakdownId) {
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
