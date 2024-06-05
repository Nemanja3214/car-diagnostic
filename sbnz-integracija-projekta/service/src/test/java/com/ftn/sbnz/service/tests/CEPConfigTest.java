package com.ftn.sbnz.service.tests;


import java.time.LocalTime;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.battery.Battery;
import com.ftn.sbnz.model.models.battery.BatteryStates;
import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
import com.ftn.sbnz.model.models.battery.events.VoltageReadingEvent;
import com.ftn.util.Simulation;

// import com.ftn.sbnz.model.models.battery.events.CurrentReadingEvent;
// import com.ftn.sbnz.model.models.battery.events.VoltageReadingEvent;


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
    //     s.add(Symptom.WEIRD_NOISE_ACCELERATION);
    //     s.add(Symptom.WHITE_SMOKE);
    //     Breakdown b = new Breakdown("kvar1", s);
    //     GasCar car = new GasCar();
    //     car.setPlate("1");
    //     Lamp l = new Lamp("Engine", "lamp", "1");
    //     List<Lamp> lamps = new ArrayList<Lamp>();
    //     lamps.add(l);
    //     car.setLamps(lamps);
    //     car.setPotentionalEngineIssue(false);
    //      ksession.insert(car);
    //     b.setCar(car);
    //     ksession.insert(b);
    //     int ruleCount = ksession.fireAllRules();
    // }

//     //     @Test
//     // public void tes1() {
//     //     // KieServices ks = KieServices.Factory.get();
//     //     // KieContainer kContainer = ks.getKieClasspathContainer(); 
//     //     // KieSession ksession = kContainer.newKieSession("cepKsession");
//     //     KieServices ks = KieServices.Factory.get();
//     //     KieContainer kContainer = ks.getKieClasspathContainer();
//     //     KieSession ksession = kContainer.newKieSession("carKsession");
//     //     List<Symptom> s = new ArrayList<>();
//     //     s.add(Symptom.DIFFICULT_STEERING);
//     //     s.add(Symptom.FLAT_TIRE);
//     //     Breakdown b = new Breakdown("kvar2", s);
//     //      ElectricCar car = new ElectricCar();
//     //      ksession.insert(car);
//     //     b.setCar(car);
//     //     ksession.insert(b);
//     //     int ruleCount = ksession.fireAllRules();
//     // }

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


        // @Test
        // public void test4() {
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
        //     b.setId(1);
        //     ElectricCar car = new ElectricCar();
       
        //     b.setCar(car);
        //     car.setFaultCheck(true);
        //     FaultCodes code = Util.randomCode(); 
        //     code = FaultCodes.ELECTRICAL_CODE_A;
        //     car.addCode(code);
        //     b.setCar(car);
        //     FaultProblem problem = new FaultProblem(b.getId());
        //       ksession.insert(car);
        //     ksession.insert(b);
        //     ksession.insert(problem);
        //     ksession.getAgenda().getAgendaGroup("checking faults").setFocus();
        //     int ruleCount = ksession.fireAllRules();
        //     ksession.getAgenda().clear();

        // }


//     // just first current measurement
//     // @Test
//     // public void testCEP() {
//     //     KieServices ks = KieServices.Factory.get();
//     //     KieContainer kContainer = ks.getKieClasspathContainer(); 
//     //     KieSession ksession = kContainer.newKieSession("cepKsession");
//     //     VoltageReadingEvent voltageEvent = new VoltageReadingEvent(4.4, 1L);
//     //     CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(1.1, 1L);
//     //     ksession.insert(voltageEvent);
//     //     ksession.fireAllRules();
//     //     ksession.insert(currentReadingEvent);
//     //     ksession.fireAllRules();

//     // }

//     // low number of readings
    //     @Test
    // public void testCEP() throws InterruptedException {
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     KieSession ksession = kContainer.newKieSession("cepKsession");
    //     Battery battery = new Battery(5, 5);
    //     battery.setId(1L);

    //     Breakdown b = new Breakdown();
    //     b.setId(1);
    //     battery.setCurrentBreakdownId(b.getId());

    //     double currentValue = Simulation.calculateValue(20);
    //      double voltageValue = Simulation.calculateValue(20);
    //       System.out.println(currentValue);
    //           System.out.println(voltageValue);
    //     ksession.insert(battery);
    //     ksession.insert(b);
    //     while(currentValue > 0.0){
    //         CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, 1L);
    //         VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, 1L);

    //         ksession.insert(voltageEvent);
    //         ksession.insert(currentReadingEvent);
    //         ksession.getAgenda().getAgendaGroup("checking battery").setFocus();
    //         ksession.fireAllRules();
    //         ksession.halt();
    //           System.out.println(currentValue);
    //           System.out.println(voltageValue);
    //         Thread.sleep(30* 1000);
    //         currentValue = Simulation.calculateValue(20);
    //         voltageValue = Simulation.calculateValue(20);
          
    //     }
    //     Simulation.lastStart = null;

    // }

    // //    happy path
    //     @Test
    // public void testCEP() throws InterruptedException {
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     KieSession ksession = kContainer.newKieSession("cepKsession");
    //     Battery battery = new Battery(5, 5);

    //     battery.setState(BatteryStates.INITIAL);
    //     battery.setId(1L);

    //     Breakdown b = new Breakdown();
    //     b.setId(1);
    //     battery.setCurrentBreakdownId(b.getId());

        
    //     double scale = 20.0;
    //     ksession.setGlobal("tolerance", 0.01);
    //     LocalTime now = LocalTime.now();

    //     double currentValue = Simulation.calculateValue(scale, now);
    //      double voltageValue = Simulation.calculateValue(scale, now);
    //       System.out.println(currentValue);
    //           System.out.println(voltageValue);
    //     ksession.insert(battery);
    //     ksession.insert(b);
    //     do{
    //         CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, 1L, );
    //         VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, 1L);

    //         ksession.insert(voltageEvent);
    //         ksession.insert(currentReadingEvent);
    //         ksession.getAgenda().getAgendaGroup("checking battery").setFocus();
    //         ksession.fireAllRules();
    //         ksession.halt();
    //           System.out.println(currentValue);
    //         //   System.out.println(voltageValue);
    //         Thread.sleep(1000);
    //         currentValue = Simulation.calculateValue(scale, now);
    //         voltageValue = Simulation.calculateValue(scale, now);
          
    //     }while(!Simulation.finished);
    //     Simulation.lastStart = null;
    //     Simulation.finished = false;

    // }

    //   //    lower voltage
    //     @Test
    // public void testCEP() throws InterruptedException {
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     KieSession ksession = kContainer.newKieSession("cepKsession");
    //     Battery battery = new Battery(5, 5);

    //     battery.setState(BatteryStates.INITIAL);
    //     battery.setId(1L);

    //     Breakdown b = new Breakdown();
    //     b.setId(1);
    //     battery.setCurrentBreakdownId(b.getId());

        
    //     double scale = 40.0;

    //     double currentValue = Simulation.calculateValue(scale);
    //      double voltageValue = Simulation.calculateValue(scale);
    //       System.out.println(currentValue);
    //           System.out.println(voltageValue);
    //     ksession.insert(battery);
    //     ksession.insert(b);
    //     do{
    //         CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, 1L);
    //         VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, 1L);

    //         ksession.insert(voltageEvent);
    //         ksession.insert(currentReadingEvent);
    //         ksession.getAgenda().getAgendaGroup("checking battery").setFocus();
    //         ksession.fireAllRules();
    //         ksession.halt();
    //           System.out.println(currentValue);
    //         //   System.out.println(voltageValue);
    //         Thread.sleep(3000);
    //         currentValue = Simulation.calculateValue(scale);
    //         voltageValue = Simulation.calculateValue(scale);
          
    //     }while(!Simulation.finished);
    //     Simulation.lastStart = null;
    //     Simulation.finished = false;
    // }

     //    
    //     @Test
    // public void testCEP() throws InterruptedException {
    //     KieServices ks = KieServices.Factory.get();
    //     KieContainer kContainer = ks.getKieClasspathContainer(); 
    //     KieSession ksession = kContainer.newKieSession("cepKsession");
    //     Battery battery = new Battery(5, 5);

    //     battery.setState(BatteryStates.INITIAL);
    //     battery.setId(1L);

    //     Breakdown b = new Breakdown();
    //     b.setId(1);
    //     battery.setCurrentBreakdownId(b.getId());

        
    //     double scale = 20.0;
    //     ksession.setGlobal("tolerance", 0.01);

    //     double currentValue = Simulation.calculate3PartValue(scale);
    //      double voltageValue = Simulation.calculate3PartValue(scale);
    //       System.out.println(currentValue);
    //           System.out.println(voltageValue);
    //     ksession.insert(battery);
    //     ksession.insert(b);
    //     do{
    //         CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(currentValue, 1L);
    //         VoltageReadingEvent voltageEvent = new VoltageReadingEvent(voltageValue, 1L);

    //         ksession.insert(voltageEvent);
    //         ksession.insert(currentReadingEvent);
    //         ksession.getAgenda().getAgendaGroup("checking battery").setFocus();
    //         ksession.fireAllRules();
    //         ksession.halt();
    //           System.out.println(currentValue);
    //         //   System.out.println(voltageValue);
    //         Thread.sleep(1000);
    //         currentValue = Simulation.calculate3PartValue(scale);
    //         voltageValue = Simulation.calculate3PartValue(scale);
          
    //     }while(!Simulation.finished);
    //     Simulation.lastStart = null;
    //     Simulation.finished = false;
    // }

//     @Test
//     public void testBackward() {
//         KieServices ks = KieServices.Factory.get();
//         KieContainer kContainer = ks.getKieClasspathContainer();
//         KieSession ksession = kContainer.newKieSession("bwKsession");
//         Car car = new Car();
//         car.setPlate("1");
//         Lamp l1 = new Lamp("Root", "Malfunction", "1");

//         Lamp l2 = new Lamp("Service", "Root", "1");
//         Lamp l3 = new Lamp("Transmission", "Root", "1");

//         Lamp l4 = new Lamp("Oil", "Service", "1");
//         Lamp l5 = new Lamp("Engine", "Service", "1");

//         Lamp l6 = new Lamp("Small Service", "Oil", "1");
//         Lamp l7 = new Lamp("Big Service", "Engine", "1");

//         Lamp l8 = new Lamp("Transmission Service", "Transmission", "1");
//         Lamp l9 = new Lamp("Clutch Service", "Clutch", "1");
//         Lamp l10 = new Lamp("Clutch", "Transmission", "1");
//         ksession.insert(car);
// //        ksession.insert(l1);
// //        ksession.insert(l2);
// //        ksession.insert(l3);
// //        ksession.insert(l4);
// //        ksession.insert(l5);
// //        ksession.insert(l6);
// //        ksession.insert(l7);
// //        ksession.insert(l8);
// //        ksession.insert(l9);
// //        ksession.insert(l10);
//         Breakdown b = new Breakdown();
//         b.setCar(car);
//         List<Symptom> s = new ArrayList<>();
//         s.add(Symptom.NO_START);
//         b.setSymptoms(s);
//         ksession.insert(b);
//         Symptom sy = Symptom.NO_START;
//         ksession.insert(sy);
//         ksession.fireAllRules();



//     }
//     @Test
//     public void testSimpleTemplateWithObjects(){

//         InputStream template = null;
//         try {
//             template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\discount.drt");
//         } catch (FileNotFoundException e) {
//             throw new RuntimeException(e);
//         }


// //        List<Double> data = new ArrayList<Double>();
// //
// //        data.add(1.0);
//         DataProvider data = new ArrayDataProvider(new String[][]{
//                 new String[]{"100", "200"}
//         });
        
//         ObjectDataCompiler converter = new ObjectDataCompiler();
//         String drl = converter.compile(data, template);
        
//         System.out.println(drl);
        
//         KieSession ksession = createKieSessionFromDRL(drl);

//         Repairment r = new Repairment();
//         r.setPrice(203.0);
//         Car car = new Car();
//         Breakdown b = new Breakdown();
//         b.setCar(car);
//         r.setBreakdown(b);
//         List<Repairment> rrs = new ArrayList<>();
//         rrs.add(r);
//         car.setRepairments(rrs);

//         Repairment nr = new Repairment();
//         nr.setPrice(104.0);
//         Breakdown nb = new Breakdown();
//         nr.setBreakdown(nb);
//         nb.setCar(car);
//         ksession.insert(b);
//         ksession.insert(car);
//         ksession.fireAllRules();
//         ksession.insert(r);
//         ksession.fireAllRules();
//         ksession.insert(nr);
//         System.out.println(nr.getPrice());
//         ksession.insert(nb);
//         ksession.fireAllRules();

//         System.out.println(nr.getPrice());
//     }

//     @Test
//     public void testServiceTemplate(){

//         InputStream template = null;
//         try {
//             template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\services.drt");
//         } catch (FileNotFoundException e) {
//             throw new RuntimeException(e);
//         }


//         DataProvider data = new ArrayDataProvider(new String[][]{
//                 new String[]{"15000", "90000", "40000", "18000"}
//         });

//         ObjectDataCompiler converter = new ObjectDataCompiler();
//         String drl = converter.compile(data, template);

//         System.out.println(drl);

//         KieSession ksession = createKieSessionFromDRL(drl);

//         Car car = new Car();
//         List<Repairment> rrs = new ArrayList<>();
//         car.setRepairments(rrs);
//         car.setKm(45000);
//         FactHandle fh = ksession.insert(car);
//         System.out.println(car.getRepairments().size());
//         ksession.fireAllRules();
//         System.out.println(car.getRepairments().size());
//         car.setKm(80000);
//         ksession.update(fh, car);
//         ksession.fireAllRules();
//         System.out.println(car.getRepairments().size());
//         car.setKm(180000);
//         ksession.update(fh, car);
//         ksession.fireAllRules();
//         System.out.println(car.getRepairments().size());
//         car.setKm(36000);
//         ksession.update(fh, car);

//         ksession.fireAllRules();
//         System.out.println(car.getRepairments().size());




//     }

//     private KieSession createKieSessionFromDRL(String drl){
//         KieHelper kieHelper = new KieHelper();
//         kieHelper.addContent(drl, ResourceType.DRL);
//
//         Results results = kieHelper.verify();
//
//         if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
//             List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
//             for (Message message : messages) {
//                 System.out.println("Error: "+message.getText());
//             }
//
//             throw new IllegalStateException("Compilation errors were found. Check the logs.");
//         }
//
//         return kieHelper.build().newKieSession();
//     }

}
