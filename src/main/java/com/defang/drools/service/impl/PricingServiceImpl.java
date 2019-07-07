package com.defang.drools.service.impl;

import com.defang.drools.model.Order;
import com.defang.drools.model.Result;
import com.defang.drools.service.KieService;
import com.defang.drools.service.PricingService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {
    @Autowired
    private KieService kieService;

    @Override
    public Result getTheResult (Order order){
        /**
         * 根据客户类型打折
         */
        KieSession kieSession1 = kieService.getKieSession("DiscountByCustomer");
        Result result = new Result(order);
        kieSession1.insert(order);
        kieSession1.insert(result);
        kieSession1.fireAllRules();
        kieSession1.dispose();

        /**
         * 根据支付类型打折
         */
        KieSession kieSession2 = kieService.getKieSession("ReductionByPayment");
        kieSession2.insert(order);
        kieSession2.insert(result);
        kieSession2.fireAllRules();
        kieSession2.dispose();

        return result;
    }
}
