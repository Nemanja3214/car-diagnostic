package com.ftn.sbnz.model.models.battery.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;



@Role(Role.Type.EVENT)
@Timestamp("startTime")
public class BatteryDischargeEvent implements Serializable{
        private static final long serialVersionUID = 1L;
       private Date startTime;

public BatteryDischargeEvent() {
    this.startTime = new Date();
}

public Date getStartTime() {
    return startTime;
}

public void setStartTime(Date startTime) {
    this.startTime = startTime;
}
}
