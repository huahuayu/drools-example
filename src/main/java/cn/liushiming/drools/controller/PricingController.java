package cn.liushiming.drools.controller;

import cn.liushiming.drools.service.PricingService;
import cn.liushiming.drools.model.Order;
import cn.liushiming.drools.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiming
 */
@RestController
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping("/getPrice")
    public Result getPrice(@RequestBody Order order) {
        return pricingService.getTheResult(order);
    }
}
