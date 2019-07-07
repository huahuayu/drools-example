package com.defang.drools;

import com.defang.drools.dto.Car;
import com.defang.drools.dto.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class DroolsTest {
    @Test
    public void costPrice() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("costprice");// 参数kSessionName就是对于META_INF的ksession name
        System.out.println(kieSession);

        Person person = new Person("shiming", 30);
        Car car = new Car("宝马", 1000.00f);
        car.setPerson(person);
        kieSession.insert(car);

        int count = kieSession.fireAllRules();
        System.out.println("触发规则数："+ count);

        kieSession.dispose();

    }

}
