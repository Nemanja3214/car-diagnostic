package com.ftn.util;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.Repairment;

public class KieUtil {
    
    public static List<Repairment> getNewlyAdded(KieSession kSession){
        List<Repairment> newlyAdded = new ArrayList<>();
        for (Object fact : kSession.getObjects()) {
            if (fact instanceof Repairment) {
                Repairment repairment = (Repairment) fact;
                // Now you have a reference to TypeB instance, do whatever you need
                System.out.println("Found Repairment instance: " + repairment);
                newlyAdded.add(repairment);
            }
        }
        return newlyAdded;
    }
}
