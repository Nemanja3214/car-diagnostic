package com.ftn.sbnz.service.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.FaultCodes;
import com.ftn.sbnz.model.models.GasCar;
import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.model.models.Util;
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
        s.add(Symptom.HEADLIGHTS_ON);
        s.add(Symptom.NO_START);
        Breakdown b = new Breakdown("kvar1", s);
        GasCar car = new GasCar();
         ksession.insert(car);
        b.setCar(car);
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }

        @Test
    public void tes1() {
        // KieServices ks = KieServices.Factory.get();
        // KieContainer kContainer = ks.getKieClasspathContainer(); 
        // KieSession ksession = kContainer.newKieSession("cepKsession");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("carKsession");
        List<Symptom> s = new ArrayList<>();
        s.add(Symptom.DIFFICULT_STEERING);
        s.add(Symptom.FLAT_TIRE);
        Breakdown b = new Breakdown("kvar2", s);
         ElectricCar car = new ElectricCar();
         ksession.insert(car);
        b.setCar(car);
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }

         @Test
    public void test3() {
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
        ElectricCar car = new ElectricCar();
         ksession.insert(car);
        b.setCar(car);
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }


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
            ElectricCar car = new ElectricCar();
       
            b.setCar(car);
            car.setFaultCheck(true);
            FaultCodes code = Util.randomCode(); 
            code = FaultCodes.ELECTRICAL_CODE_C;
            car.addCode(code);
            b.setCar(car);
            FaultProblem problem = new FaultProblem();
              ksession.insert(car);
            ksession.insert(b);
            ksession.insert(problem);
            ksession.getAgenda().getAgendaGroup("checking faults").setFocus();
            int ruleCount = ksession.fireAllRules();
            ksession.halt();

            if(problem.getKind().equals(FaultProblemKinds.POWERTRAIN))
                problem = Util.checkPowertrain();
            else if(problem.getKind().equals(FaultProblemKinds.AUXILIARY))
                problem = Util.checkAuxiliary();
            else
                problem = Util.checkRegenerativeBreaking();
            
            ksession.getAgenda().clear();
            ksession.insert(problem);
            ruleCount = ksession.fireAllRules();

        }


}
