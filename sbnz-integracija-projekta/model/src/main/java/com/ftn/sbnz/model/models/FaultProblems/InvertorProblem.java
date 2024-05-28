package com.ftn.sbnz.model.models.FaultProblems;
import java.util.Objects;

public class InvertorProblem  extends PowertrainProblems{
    private double resistance;


    public InvertorProblem(double resistance, long breakdownId) {
        this(breakdownId );
        this.resistance = resistance;

    }

    public double getResistance() {
        return this.resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }


    public InvertorProblem(long breakdownId) {
        super(breakdownId);
    }

    @Override
    public String toString() {
        return "{" +
            "}";
    }
    
}
