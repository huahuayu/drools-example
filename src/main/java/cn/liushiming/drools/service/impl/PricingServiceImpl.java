package cn.liushiming.drools.service.impl;

import cn.liushiming.drools.service.KieService;
import cn.liushiming.drools.service.PricingService;
import cn.liushiming.drools.model.Order;
import cn.liushiming.drools.model.Result;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shiming
 */
@Service
public class PricingServiceImpl implements PricingService {
    @Autowired
    private KieService kieService;

    @Override
    public Result getTheResult (Order order){
        // get discount by customer type
        KieSession kieSession1 = kieService.getKieSession("DiscountByCustomer");
        Result result = new Result(order);
        kieSession1.insert(order);
        kieSession1.setGlobal("result",result);
        kieSession1.fireAllRules();
        kieSession1.dispose();

        // get reduction by payment method
        KieSession kieSession2 = kieService.getKieSession("ReductionByPayment");
        kieSession2.insert(order);
        kieSession2.setGlobal("result",result);
        kieSession2.fireAllRules();
        kieSession2.dispose();

        return result;
    }
}
