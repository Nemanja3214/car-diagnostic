package com.ftn.sbnz.model.models.battery.events;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.ftn.sbnz.model.models.battery.sensors.GeneratorUtil;


@Role(Role.Type.EVENT)
@Timestamp("startTime")
public class VoltageReadingEvent {
           private Date startTime;
       private double value;
       private Long batteryId;
       private double initialSOC;

        private double maxVoltage = 0.0;



    public double getMaxVoltage() {
        return this.maxVoltage;
    }

    public void setMaxVoltage(double maxVoltage) {
        this.maxVoltage = maxVoltage;
    }
    


    // public VoltageReadingEvent() {
    // }

    public double getInitialSOC() {
        return this.initialSOC;
    }

    public void setInitialSOC(double initialSOC) {
        this.initialSOC = initialSOC;
    }

    public VoltageReadingEvent(double value, Long batteryId, Date startTime) {
        this.startTime = startTime;
        this.value = value;
        this.batteryId = batteryId;
        initialSOC = GeneratorUtil.getInitialSoc(value);
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getBatteryId() {
        return this.batteryId;
    }

    public void setBatteryId(Long batteryId) {
        this.batteryId = batteryId;
    }

    public VoltageReadingEvent startTime(Date startTime) {
        setStartTime(startTime);
        return this;
    }

    public VoltageReadingEvent value(double value) {
        setValue(value);
        return this;
    }

    public VoltageReadingEvent batteryId(Long batteryId) {
        setBatteryId(batteryId);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " startTime='" + getStartTime() + "'" +
            ", value='" + getValue() + "'" +
            ", batteryId='" + getBatteryId() + "'" +
            "}";
    }
}
