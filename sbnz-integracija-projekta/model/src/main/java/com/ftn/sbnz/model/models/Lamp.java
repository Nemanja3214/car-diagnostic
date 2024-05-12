package model.src.main.java.com.ftn.sbnz.model.models;

import java.util.List;

public class Lamp {

    private String lampKind;

    private List<Lamp> causedBy;

    public Lamp() {}

    public String getLampKind() {
        return lampKind;
    }

    public void setLampKind(String lampKind) {
        this.lampKind = lampKind;
    }

    public List<Lamp> getCausedBy() {
        return causedBy;
    }

    public void setCausedBy(List<Lamp> causedBy) {
        this.causedBy = causedBy;
    }

    public Lamp(String lampKind, List<Lamp> causedBy) {
        this.lampKind = lampKind;
        this.causedBy = causedBy;
    }
}
