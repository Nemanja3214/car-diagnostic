package com.ftn.sbnz.service.tests;


import java.util.ArrayList;
import java.util.List;

import com.ftn.sbnz.model.models.*;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
import com.ftn.sbnz.model.models.battery.events.VoltageReadingEvent;
import com.ftn.sbnz.model.models.FaultProblems.FaultProblem;
import com.ftn.sbnz.model.models.FaultProblems.FaultProblemKinds;


public class CEPConfigTest {


    @Test
    public void test() {
        // KieServices ks = KieServices.Factory.get();
        // KieContainer kContainer = ks.getKieClasspathContainer(); 
        // KieSession ksession = kContainer.newKieSession("cepKsession");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("carKsession");
        List<Symptom> s = new ArrayList<>();
        s.add(Symptom.WEIRD_NOISE_ACCELERATION);
        s.add(Symptom.WHITE_SMOKE);
        Breakdown b = new Breakdown("kvar1", s);
        GasCar car = new GasCar();
        car.setPlate("1");
        Lamp l = new Lamp("Engine", "lamp", "1");
        List<Lamp> lamps = new ArrayList<Lamp>();
        lamps.add(l);
        car.setLamps(lamps);
        car.setPotentionalEngineIssue(false);
         ksession.insert(car);
        b.setCar(car);
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }

    //     @Test
    // public void tes1() {
    //     // KieServices ks = KieServices.Factory.get();
    //     // KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     // KieSession ksession = kContainer.newKieSession("cepKsession");
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer();
    //     KieSession ksession = kContainer.newKieSession("carKsession");
    //     List<Symptom> s = new ArrayList<>();
    //     s.add(Symptom.DIFFICULT_STEERING);
    //     s.add(Symptom.FLAT_TIRE);
    //     Breakdown b = new Breakdown("kvar2", s);
    //      ElectricCar car = new ElectricCar();
    //      ksession.insert(car);
    //     b.setCar(car);
    //     ksession.insert(b);
    //     int ruleCount = ksession.fireAllRules();
    // }

    //      @Test
    // public void test3() {
    //     // KieServices ks = KieServices.Factory.get();
    //     // KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     // KieSession ksession = kContainer.newKieSession("cepKsession");
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer();
    //     KieSession ksession = kContainer.newKieSession("carKsession");
    //     List<Symptom> s = new ArrayList<>();
    //     // s.add(Symptom.JERKING);
    //     // s.add(Symptom.FLAT_TIRE);
    //     Breakdown b = new Breakdown("kvar2", s);
    //     ElectricCar car = new ElectricCar();
    //      ksession.insert(car);
    //     b.setCar(car);
    //     ksession.insert(b);
    //     int ruleCount = ksession.fireAllRules();
    // }


    //     @Test
    //     public void test4() {
    //         // KieServices ks = KieServices.Factory.get();
    //         // KieContainer kContainer = ks.getKieClasspathContainer(); 
    //         // KieSession ksession = kContainer.newKieSession("cepKsession");
    //         KieServices ks = KieServices.Factory.get();
    //         KieContainer kContainer = ks.getKieClasspathContainer();

    //         KieSession ksession = kContainer.newKieSession("carKsession");
    //         List<Symptom> s = new ArrayList<>();
    //         // s.add(Symptom.JERKING);
    //         // s.add(Symptom.FLAT_TIRE);
    //         Breakdown b = new Breakdown("kvar2", s);
    //         ElectricCar car = new ElectricCar();
       
    //         b.setCar(car);
    //         car.setFaultCheck(true);
    //         FaultCodes code = Util.randomCode(); 
    //         code = FaultCodes.ELECTRICAL_CODE_C;
    //         car.addCode(code);
    //         b.setCar(car);
    //         FaultProblem problem = new FaultProblem();
    //           ksession.insert(car);
    //         ksession.insert(b);
    //         ksession.insert(problem);
    //         ksession.getAgenda().getAgendaGroup("checking faults").setFocus();
    //         int ruleCount = ksession.fireAllRules();
    //         ksession.halt();

    //         if(problem.getKind().equals(FaultProblemKinds.POWERTRAIN))
    //             problem = Util.checkPowertrain();
    //         else if(problem.getKind().equals(FaultProblemKinds.AUXILIARY))
    //             problem = Util.checkAuxiliary();
    //         else
    //             problem = Util.checkRegenerativeBreaking();
            
    //         ksession.getAgenda().clear();
    //         ksession.insert(problem);
    //         ruleCount = ksession.fireAllRules();

    //     }


    // just first current measurement
    // @Test
    // public void testCEP() {
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     KieSession ksession = kContainer.newKieSession("cepKsession");
    //     VoltageReadingEvent voltageEvent = new VoltageReadingEvent(4.4, 1L);
    //     CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(1.1, 1L);
    //     ksession.insert(voltageEvent);
    //     ksession.fireAllRules();
    //     ksession.insert(currentReadingEvent);
    //     ksession.fireAllRules();

    // }

    // multiple current measurements
        @Test
    public void testCEP() throws InterruptedException {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer(); 
        KieSession ksession = kContainer.newKieSession("cepKsession");
        VoltageReadingEvent voltageEvent = new VoltageReadingEvent(4.4, 1L);
        CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(1.1, 1L, 5.0);
     
        ksession.insert(voltageEvent);
        ksession.fireAllRules();

        ksession.insert(currentReadingEvent);
        // System.out.println("FIRST ONE TIME: " + currentReadingEvent.getStartTime().getTime());
        ksession.fireAllRules();

           Thread.sleep(3000);
              CurrentReadingEvent currentReadingEvent2 = new CurrentReadingEvent(1.1, 1L, 5.0);
         ksession.insert(currentReadingEvent2);
        //  System.out.println("SECOND ONE TIME: " + currentReadingEvent2.getStartTime().getTime());
         ksession.fireAllRules();

         Thread.sleep(1000);
                   CurrentReadingEvent currentReadingEvent3 = new CurrentReadingEvent(1.1, 1L, 5.0);
        //  System.out.println("THIRD ONE TIME: " + currentReadingEvent3.getStartTime().getTime());
          ksession.insert(currentReadingEvent3);
         ksession.fireAllRules();

    }


    @Test
    public void testBackward() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("bwKsession");
        Car car = new Car();
        car.setPlate("1");
        Lamp l1 = new Lamp("Root", "Malfunction", "1");

        Lamp l2 = new Lamp("Service", "Root", "1");
        Lamp l3 = new Lamp("Transmission", "Root", "1");

        Lamp l4 = new Lamp("Oil", "Service", "1");
        Lamp l5 = new Lamp("Engine", "Service", "1");

        Lamp l6 = new Lamp("Small Service", "Oil", "1");
        Lamp l7 = new Lamp("Big Service", "Engine", "1");

        Lamp l8 = new Lamp("Transmission Service", "Transmission", "1");
        Lamp l9 = new Lamp("Clutch Service", "Clutch", "1");
        Lamp l10 = new Lamp("Clutch", "Transmission", "1");
        ksession.insert(car);
//        ksession.insert(l1);
//        ksession.insert(l2);
//        ksession.insert(l3);
//        ksession.insert(l4);
//        ksession.insert(l5);
//        ksession.insert(l6);
//        ksession.insert(l7);
//        ksession.insert(l8);
//        ksession.insert(l9);
//        ksession.insert(l10);
        Breakdown b = new Breakdown();
        b.setCar(car);
        List<Symptom> s = new ArrayList<>();
        s.add(Symptom.NO_START);
        b.setSymptoms(s);
        ksession.insert(b);
        Symptom sy = Symptom.NO_START;
        ksession.insert(sy);
        ksession.fireAllRules();



    }


}
