package com.huahuayu.drools.service.impl;
import com.huahuayu.drools.service.KieService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class KieServiceImpl implements KieService {

    @Override
    public KieSession getKieSession(String kieName) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession(kieName);
        return kieSession;
    }

}
