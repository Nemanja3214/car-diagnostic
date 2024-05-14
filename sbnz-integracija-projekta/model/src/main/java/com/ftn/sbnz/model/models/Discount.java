package com.ftn.sbnz.model.models;



public class Discount {
    private double percent;

    public Discount() {}

    public Discount(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
