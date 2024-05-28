package com.ftn.sbnz.model.models;

import java.util.List;
import org.kie.api.definition.type.Position;


public class Lamp {
    @Position(0)
    private String lampKind;
    @Position(2)
    private String plate;
    @Position(1)
    private String causedByLamp;

    private Integer id;

    public Lamp(String lampKind, String plate, String causedByLamp, Integer id) {
        this.lampKind = lampKind;
        this.plate = plate;
        this.causedByLamp = causedByLamp;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lamp() {}

    public String getLampKind() {
        return lampKind;
    }

    public Lamp(String lampKind, String causedByLamp, String plate) {
        this.lampKind = lampKind;
        this.plate = plate;
        this.causedByLamp = causedByLamp;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCausedByLamp() {
        return causedByLamp;
    }

    public void setCausedByLamp(String causedByLamp) {
        this.causedByLamp = causedByLamp;
    }

    public void setLampKind(String lampKind) {
        this.lampKind = lampKind;
    }

}
