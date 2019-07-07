package com.defang.drools.service;

import org.kie.api.runtime.KieSession;

public interface KieService {
    /**
     * 通过kieName获得kieSession
     *
     * @param kieName
     * @return KieSession
     */
    KieSession getKieSession(String kieName);
}