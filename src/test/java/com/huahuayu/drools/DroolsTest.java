package com.huahuayu.drools;

import com.huahuayu.drools.model.Customer;
import com.huahuayu.drools.model.Order;
import com.huahuayu.drools.model.Payment;
import com.huahuayu.drools.model.Product;
import com.huahuayu.drools.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsTest {

    @Autowired
    private PricingService pricingService;

    @Test
    public void getPriceTest() {
        Order order1 = new Order(1,new Customer("alice","2"),new Product("iphoneXR",1000.00f), new Payment("wepay"));
        Order order2 = new Order(2,new Customer("bob","1"),new Product("macbook pro",2000.00f), new Payment("creditCard"));
        Order order3 = new Order(3,new Customer("eva","3"),new Product("mouse",99.00f), new Payment("alipay"));
        Order order4 = new Order(3,new Customer("frank","4"),new Product("airpod",200.00f), new Payment("alipay"));

        System.out.println(pricingService.getTheResult(order1));
        System.out.println(pricingService.getTheResult(order2));
        System.out.println(pricingService.getTheResult(order3));
        System.out.println(pricingService.getTheResult(order4));
    }

}
