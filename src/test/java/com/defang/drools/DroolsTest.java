package com.defang.drools;

import com.defang.drools.model.Customer;
import com.defang.drools.model.Order;
import com.defang.drools.model.Payment;
import com.defang.drools.model.Product;
import com.defang.drools.service.PricingService;
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
        Order order1 = new Order(new Customer("alice","2"),new Product("iphoneXR",1000.00f), new Payment("wepay"));
        Order order2 = new Order(new Customer("bob","1"),new Product("macbook pro",2000.00f), new Payment("creditCard"));
        Order order3 = new Order(new Customer("eva","3"),new Product("mouse",99.00f), new Payment("alipay"));

        System.out.println(pricingService.getTheResult(order1));
        System.out.println(pricingService.getTheResult(order2));
        System.out.println(pricingService.getTheResult(order3));
    }

}
