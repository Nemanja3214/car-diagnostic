package com.ftn.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

public class Container {
    private static KieContainer kContainer;

    private Container() { }

    public static synchronized KieContainer getKieContainer() {
        if (kContainer == null) {
            KieServices kieServices = KieServices.Factory.get();
            kContainer = kieServices.getKieClasspathContainer();
        }
        return kContainer;
    }
}
