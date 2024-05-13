package com.ftn.sbnz.service.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.ElectricCar;
import com.ftn.sbnz.model.models.GasCar;
import com.ftn.sbnz.model.models.Symptom;



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
        b.setCar(new GasCar());
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
        b.setCar(new ElectricCar());
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }
}
