package com.practice.other;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class DroolsRuleEngine {
    private KieContainer kContainer;

    public DroolsRuleEngine () {
        KieServices kieService = KieServices.Factory.get();
        kContainer = ks.getKieClasspathContainer();
    }

    public void evaluate(String sessionName, List<?> facts) {
        KieSession kSession = kContainer.newKieSession(sessionName);
        try {
            facts.forEach(x -> kSession.insert(x));
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
    }
}
