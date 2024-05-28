package com.ftn.sbnz.model.models.FaultProblems;
import java.util.Objects;

public class WheelSpeedProblem extends RegenerativeBreakingProblem{
    private double matching;

    public WheelSpeedProblem(long breakdownId) {
        super(breakdownId);
    }

    public WheelSpeedProblem(double matching, long breakdownId) {
        this(breakdownId);
        this.matching = matching;
    }

    public double getMatching() {
        return this.matching;
    }

    public void setMatching(double matching) {
        this.matching = matching;
    }

    public WheelSpeedProblem matching(double matching) {
        setMatching(matching);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " matching='" + getMatching() + "'" +
            "}";
    }
    
    
}
