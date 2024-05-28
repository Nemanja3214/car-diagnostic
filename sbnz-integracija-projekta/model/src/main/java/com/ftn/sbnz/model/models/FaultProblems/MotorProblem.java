package com.ftn.sbnz.model.models.FaultProblems;
import java.util.Objects;

public class MotorProblem extends PowertrainProblems{
    private int responsivness;


    public MotorProblem(long breakdownId) {
        super(breakdownId);
    }

    public MotorProblem(int responsivness, long breakdownId) {
        this(breakdownId);
        this.responsivness = responsivness;
    }

    public int getResponsivness() {
        return this.responsivness;
    }

    public void setResponsivness(int responsivness) {
        this.responsivness = responsivness;
    }

    public MotorProblem responsivness(int responsivness) {
        setResponsivness(responsivness);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " responsivness='" + getResponsivness() + "'" +
            "}";
    }
    
}
