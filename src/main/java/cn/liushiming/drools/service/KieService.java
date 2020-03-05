package cn.liushiming.drools.service;

import org.kie.api.runtime.KieSession;

/**
 * @author shiming
 */
public interface KieService {
    KieSession getKieSession(String kieName);
}