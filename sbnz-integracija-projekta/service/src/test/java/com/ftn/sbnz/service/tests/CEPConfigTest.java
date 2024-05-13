package com.ftn.sbnz.service.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
 import org.kie.api.KieServices;
 import org.kie.api.runtime.KieContainer;
 import org.kie.api.runtime.KieSession;
import com.ftn.sbnz.model.models.Symptom;
import com.ftn.sbnz.model.models.Breakdown;



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
        ksession.insert(b);
        int ruleCount = ksession.fireAllRules();
    }
}
