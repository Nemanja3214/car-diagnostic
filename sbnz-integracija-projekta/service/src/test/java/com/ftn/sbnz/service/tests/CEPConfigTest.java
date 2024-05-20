package com.ftn.sbnz.service.tests;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
import com.ftn.sbnz.model.models.battery.events.VoltageReadingEvent;


public class CEPConfigTest {

    // @Test
    // public void test() {
    //     // KieServices ks = KieServices.Factory.get();
    //     // KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     // KieSession ksession = kContainer.newKieSession("cepKsession");
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer();
    //     KieSession ksession = kContainer.newKieSession("carKsession");
    //     List<Symptom> s = new ArrayList<>();
    //     s.add(Symptom.HEADLIGHTS_ON);
    //     s.add(Symptom.NO_START);
    //     Breakdown b = new Breakdown("kvar1", s);
    //     GasCar car = new GasCar();
    //      ksession.insert(car);
    //     b.setCar(car);
    //     ksession.insert(b);
    //     int ruleCount = ksession.fireAllRules();
    // }

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



}
