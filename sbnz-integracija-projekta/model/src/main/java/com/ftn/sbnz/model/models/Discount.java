package com.ftn.sbnz.model.models;

import javax.persistence.*;

@Entity
@Table
public class Discount {
    private double percent;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Discount(double percent, Integer id) {
        this.percent = percent;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
