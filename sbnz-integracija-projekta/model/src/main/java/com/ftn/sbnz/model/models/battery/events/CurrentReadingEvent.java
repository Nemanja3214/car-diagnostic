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
    //    private double currentSOC;
       private double currentCharge;

       private double maxCharge = 0.0;

    public double getMaxCharge() {
        return this.maxCharge;
    }

    public void setMaxCharge() {
        this.maxCharge = currentCharge;
        // System.out.println("CURRENT MAX: " + maxCharge);
    }

    public void setMaxCharge(double val) {
        this.maxCharge = val;
            //   System.out.println("CURRENT MAX: " + maxCharge);
    }


    public double getCurrentCharge() {
        return this.currentCharge;
    }

    public void setCurrentCharge(double val) {
        this.currentCharge = val;
    }

     public void setNextCharge(double timeDiff) {
        // System.out.println(currentCharge + " - " + timeDiff + " * " + this.value);
        this.currentCharge = currentCharge - timeDiff * this.value;
        if(currentCharge < 0)
            currentCharge = 0.0;
        return;
    }


    public CurrentReadingEvent(double value, Long batteryId, double maxCharge, Date startTime) {
        this.startTime = startTime;
        this.value = value;
        this.batteryId = batteryId;
        this.maxCharge = maxCharge;
        this.currentCharge = 0;
    }
      public CurrentReadingEvent(double value, Long batteryId, Date startTime) {
        this.startTime = startTime;
        this.value = value;
        this.batteryId = batteryId;
          this.currentCharge = 0;
    }

    //   @Modifies( { "currentSOC" } )
    // public void calculateAndSetSOC(double timeDiff){
    //     if(maxCharge == 0.0){
    //         // System.out.println("MAX is not set");
    //         return;
    //     }
    //     double consumedCharge = value * timeDiff;
        
    //     // Calculate the new SOC
    //     currentSOC = currentSOC - (consumedCharge / maxCharge);
    //     currentSOC = Math.max(0, Math.min(1, currentSOC));
    //     // System.out.println(currentSOC);

    //     return (currentCharge / maxCharge) * 100;
    // }

public double getCurrentSOC() {
    //  System.out.println("CURRENT MAX: " + maxCharge);
    //  System.out.println("CURRENT SOC: " + (currentCharge / maxCharge) * 100);
        if(maxCharge != 0.0){
            double v = (currentCharge / maxCharge) * 100.0;
            if(v < 0.0)
                return 0.0; 
            if(v > 100.0)
                return 100.0;
            return v;
        }
           
        return 0.0;
    }

    // @Modifies( { "currentSOC" } )
    // public void setCurrentSOC(double currentSOC) {
    //     this.currentSOC = currentSOC;
    // }

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
