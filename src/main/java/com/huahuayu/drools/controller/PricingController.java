package com.huahuayu.drools.controller;

import com.huahuayu.drools.model.Order;
import com.huahuayu.drools.model.Result;
import com.huahuayu.drools.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping
    public Result getFinalPrice(@RequestBody Order order) {
        Result result = pricingService.getTheResult(order);
        System.out.println(result);
        return result;
    }

    @GetMapping("/health")
    public String healthCheck(){
        return "up";
    }
}
