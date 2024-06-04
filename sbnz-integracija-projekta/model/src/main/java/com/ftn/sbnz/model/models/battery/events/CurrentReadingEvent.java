package com.ftn.sbnz.model.models.battery.events;

import java.util.Date;

import org.kie.api.definition.type.Modifies;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("startTime")
public class CurrentReadingEvent {
       private Date startTime;
       private double value;
       private Long batteryId;
       private double currentSOC;

       private double maxCharge = 0.0;

    public double getMaxCharge() {
        return this.maxCharge;
    }

    public void setMaxCharge() {
        // Q = I * dt, we take dt 1s, so basicaly Q = I
        this.maxCharge = value;
    }

    public CurrentReadingEvent(double value, Long batteryId, double maxCharge) {
        this.startTime = new Date();
        this.value = value;
        this.batteryId = batteryId;
        this.maxCharge = maxCharge;
    }
    public void calculateAndSetSOC(double timeDiff){
        if(maxCharge == 0.0){
            System.out.println("MAX is not set");
            return;
        }
        double consumedCharge = value * timeDiff;
        
        // Calculate the new SOC
        currentSOC = currentSOC - (consumedCharge / maxCharge);
        currentSOC = Math.max(0, Math.min(1, currentSOC));
        System.out.println(currentSOC);
    }

public double getCurrentSOC() {
        return currentSOC;
    }

    @Modifies( { "currentSOC" } )
    public void setCurrentSOC(double currentSOC) {
        this.currentSOC = currentSOC;
    }

public Long getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(long batteryId) {
        this.batteryId = batteryId;
    }

public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


public Date getStartTime() {
    return startTime;
}

public void setStartTime(Date startTime) {
    this.startTime = startTime;
}
   
}
