package com.ftn.sbnz.service.tests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.FaultCodes;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.model.models.Util;
import com.ftn.sbnz.model.models.FaultProblems.FaultProblem;
import com.ftn.sbnz.model.models.FaultProblems.FaultProblemKinds;

import org.drools.template.ObjectDataCompiler;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.ObjectDataCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.ObjectDataCompiler;
import org.drools.template.objects.ArrayDataProvider;
//import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;


public class CEPConfigTest {


//     @Test
//     public void test() {
//         // KieServices ks = KieServices.Factory.get();
//         // KieContainer kContainer = ks.getKieClasspathContainer(); 
//         // KieSession ksession = kContainer.newKieSession("cepKsession");
//         KieServices ks = KieServices.Factory.get();
//         KieContainer kContainer = ks.getKieClasspathContainer();
//         KieSession ksession = kContainer.newKieSession("carKsession");
//         List<Symptom> s = new ArrayList<>();
//         s.add(Symptom.WEIRD_NOISE_ACCELERATION);
//         s.add(Symptom.WHITE_SMOKE);
//         Breakdown b = new Breakdown("kvar1", s);
//         GasCar car = new GasCar();
//         car.setPlate("1");
//         Lamp l = new Lamp("Engine", "lamp", "1");
//         List<Lamp> lamps = new ArrayList<Lamp>();
//         lamps.add(l);
//         car.setLamps(lamps);
//         car.setPotentionalEngineIssue(false);
//          ksession.insert(car);
//         b.setCar(car);
//         ksession.insert(b);
//         int ruleCount = ksession.fireAllRules();
//     }

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

//     //      @Test
//     // public void test3() {
//     //     // KieServices ks = KieServices.Factory.get();
//     //     // KieContainer kContainer = ks.getKieClasspathContainer(); 
//     //     // KieSession ksession = kContainer.newKieSession("cepKsession");
//     //     KieServices ks = KieServices.Factory.get();
//     //     KieContainer kContainer = ks.getKieClasspathContainer();
//     //     KieSession ksession = kContainer.newKieSession("carKsession");
//     //     List<Symptom> s = new ArrayList<>();
//     //     // s.add(Symptom.JERKING);
//     //     // s.add(Symptom.FLAT_TIRE);
//     //     Breakdown b = new Breakdown("kvar2", s);
//     //     ElectricCar car = new ElectricCar();
//     //      ksession.insert(car);
//     //     b.setCar(car);
//     //     ksession.insert(b);
//     //     int ruleCount = ksession.fireAllRules();
//     // }


        @Test
        public void test4() {
            // KieServices ks = KieServices.Factory.get();
            // KieContainer kContainer = ks.getKieClasspathContainer(); 
            // KieSession ksession = kContainer.newKieSession("cepKsession");
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();

            KieSession ksession = kContainer.newKieSession("carKsession");
            List<Symptom> s = new ArrayList<>();
            // s.add(Symptom.JERKING);
            // s.add(Symptom.FLAT_TIRE);
            Breakdown b = new Breakdown("kvar2", s);
            b.setId(1);
            ElectricCar car = new ElectricCar();
       
            b.setCar(car);
            car.setFaultCheck(true);
            FaultCodes code = Util.randomCode(); 
            code = FaultCodes.ELECTRICAL_CODE_A;
            car.addCode(code);
            b.setCar(car);
            FaultProblem problem = new FaultProblem(b.getId());
              ksession.insert(car);
            ksession.insert(b);
            ksession.insert(problem);
            ksession.getAgenda().getAgendaGroup("checking faults").setFocus();
            int ruleCount = ksession.fireAllRules();
            ksession.getAgenda().clear();

        }


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

//     // multiple current measurements
//         @Test
//     public void testCEP() throws InterruptedException {
//         KieServices ks = KieServices.Factory.get();
//         KieContainer kContainer = ks.getKieClasspathContainer(); 
//         KieSession ksession = kContainer.newKieSession("cepKsession");
//         VoltageReadingEvent voltageEvent = new VoltageReadingEvent(4.4, 1L);
//         CurrentReadingEvent currentReadingEvent = new CurrentReadingEvent(1.1, 1L, 5.0);
     
//         ksession.insert(voltageEvent);
//         ksession.fireAllRules();

//         ksession.insert(currentReadingEvent);
//         // System.out.println("FIRST ONE TIME: " + currentReadingEvent.getStartTime().getTime());
//         ksession.fireAllRules();

//            Thread.sleep(3000);
//               CurrentReadingEvent currentReadingEvent2 = new CurrentReadingEvent(1.1, 1L, 5.0);
//          ksession.insert(currentReadingEvent2);
//         //  System.out.println("SECOND ONE TIME: " + currentReadingEvent2.getStartTime().getTime());
//          ksession.fireAllRules();

//          Thread.sleep(1000);
//                    CurrentReadingEvent currentReadingEvent3 = new CurrentReadingEvent(1.1, 1L, 5.0);
//         //  System.out.println("THIRD ONE TIME: " + currentReadingEvent3.getStartTime().getTime());
//           ksession.insert(currentReadingEvent3);
//          ksession.fireAllRules();

//     }


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
    @Test
    public void testSimpleTemplateWithObjects(){

        InputStream template = null;
        try {
            template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\discount.drt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


//        List<Double> data = new ArrayList<Double>();
//
//        data.add(1.0);
        DataProvider data = new ArrayDataProvider(new String[][]{
                new String[]{"100", "200"}
        });
        
        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);
        
        System.out.println(drl);
        
        KieSession ksession = createKieSessionFromDRL(drl);

        Repairment r = new Repairment();
        r.setPrice(203.0);
        Car car = new Car();
        Breakdown b = new Breakdown();
        b.setCar(car);
        r.setBreakdown(b);
        List<Repairment> rrs = new ArrayList<>();
        rrs.add(r);
        car.setRepairments(rrs);

        Repairment nr = new Repairment();
        nr.setPrice(104.0);
        Breakdown nb = new Breakdown();
        nr.setBreakdown(nb);
        nb.setCar(car);
        ksession.insert(b);
        ksession.insert(car);
        ksession.fireAllRules();
        ksession.insert(r);
        ksession.fireAllRules();
        ksession.insert(nr);
        System.out.println(nr.getPrice());
        ksession.insert(nb);
        ksession.fireAllRules();

        System.out.println(nr.getPrice());
    }

    @Test
    public void testServiceTemplate(){

        InputStream template = null;
        try {
            template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\services.drt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        DataProvider data = new ArrayDataProvider(new String[][]{
                new String[]{"15000", "90000", "40000", "18000"}
        });

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);

        System.out.println(drl);

        KieSession ksession = createKieSessionFromDRL(drl);

        Car car = new Car();
        List<Repairment> rrs = new ArrayList<>();
        car.setRepairments(rrs);
        car.setKm(45000);
        FactHandle fh = ksession.insert(car);
        System.out.println(car.getRepairments().size());
        ksession.fireAllRules();
        System.out.println(car.getRepairments().size());
        car.setKm(80000);
        ksession.update(fh, car);
        ksession.fireAllRules();
        System.out.println(car.getRepairments().size());
        car.setKm(180000);
        ksession.update(fh, car);
        ksession.fireAllRules();
        System.out.println(car.getRepairments().size());
        car.setKm(36000);
        ksession.update(fh, car);

        ksession.fireAllRules();
        System.out.println(car.getRepairments().size());




    }

    private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }

        return kieHelper.build().newKieSession();
    }

}
