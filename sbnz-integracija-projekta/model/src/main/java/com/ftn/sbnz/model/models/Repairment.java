package com.ftn.sbnz.model.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repairment {
    private LocalDateTime timeFinished;
    private double price;

    private Discount discount;
    private Mechanic mechanic;

    private Breakdown breakdown;

    private String action;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Repairment(LocalDateTime timeFinished, double price, Discount discount, Mechanic mechanic, Breakdown breakdown, String action) {
        this.timeFinished = timeFinished;
        this.price = price;
        this.discount = discount;
        this.mechanic = mechanic;
        this.breakdown = breakdown;
        this.action = action;
    }

    public Repairment(LocalDateTime timeFinished, double price, Discount discount, Mechanic mechanic, Breakdown breakdown, String action, Integer id) {
        this.timeFinished = timeFinished;
        this.price = price;
        this.discount = discount;
        this.mechanic = mechanic;
        this.breakdown = breakdown;
        this.action = action;
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
