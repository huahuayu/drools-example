package cn.liushiming.drools.service.impl;
import cn.liushiming.drools.service.KieService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @author shiming
 */
@Service
public class KieServiceImpl implements KieService {

    @Override
    public KieSession getKieSession(String kieName) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newKieSession(kieName);
    }

}
