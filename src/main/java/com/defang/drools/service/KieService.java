package com.defang.drools.service;

import org.kie.api.runtime.KieSession;

public interface KieService {
    /**
     * get kieSession by kieName
     *
     * @param kieName
     * @return KieSession
     */
    KieSession getKieSession(String kieName);
}