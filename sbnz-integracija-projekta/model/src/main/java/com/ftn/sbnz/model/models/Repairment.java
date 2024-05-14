package com.ftn.sbnz.model.models;

import java.time.LocalDateTime;

public class Repairment {
    private LocalDateTime timeFinished;
    private double price;

    private Discount discount;
    private Mechanic mechanic;

    private Breakdown breakdown;

    public Repairment() {}

    public Repairment(LocalDateTime timeFinished, double price, Discount discount, Mechanic mechanic, Breakdown breakdown) {
        this.timeFinished = timeFinished;
        this.price = price;
        this.discount = discount;
        this.mechanic = mechanic;
        this.breakdown = breakdown;
    }

    public LocalDateTime getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(LocalDateTime timeFinished) {
        this.timeFinished = timeFinished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Breakdown getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Breakdown breakdown) {
        this.breakdown = breakdown;
    }
}
