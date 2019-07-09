package com.huahuayu.drools;

import com.huahuayu.drools.model.*;
import com.huahuayu.drools.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsTest {

    @Autowired
    private PricingService pricingService;


    @Test
    public void getPriceTest() {
        // alice, vip， buy iphoneXR，price $1000, use wepay
        Order order1 = new Order(1,new Customer("alice","2"),new Product("iphoneXR",1000.00f), new Payment("wepay"));
        // bob, ordinary customer，buy macbook pro，price $2000, use credit card
        Order order2 = new Order(2,new Customer("bob","1"),new Product("macbook pro",2000.00f), new Payment("creditCard"));
        // eva, advanced vip，buy mouse，price $99, use alipay
        Order order3 = new Order(3,new Customer("eva","3"),new Product("mouse",99.00f), new Payment("alipay"));
        // frank, advanced vip, buy airpod, price $200, use alipay
        Order order4 = new Order(4,new Customer("frank","3"),new Product("airpod",200.00f), new Payment("alipay"));

        Result result1 = pricingService.getTheResult(order1);
        Result result2 = pricingService.getTheResult(order2);
        Result result3 = pricingService.getTheResult(order3);
        Result result4 = pricingService.getTheResult(order4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

        assertEquals("order1 finalPrice is wrong",new Float(1000.00f * 0.8 - 5),result1.getFinalPrice());
        assertEquals("order2 finalPrice is wrong",new Float(2000.00f * 0.9 - 0),result1.getFinalPrice());
        assertEquals("order3 finalPrice is wrong",new Float(99.00f * 0.7 - 0),result1.getFinalPrice());
        assertEquals("order4 finalPrice is wrong",new Float(200.00f * 0.7 - 10),result1.getFinalPrice());

    }

}
