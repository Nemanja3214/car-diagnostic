package com.ftn.sbnz.model.models.battery.events;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;


@Role(Role.Type.EVENT)
@Timestamp("startTime")
public class BatteryChargeEvent {
   private Date startTime;

public BatteryChargeEvent() {
    this.startTime = new Date();
}

public Date getStartTime() {
    return startTime;
}

public void setStartTime(Date startTime) {
    this.startTime = startTime;
}
   
   
    
}
