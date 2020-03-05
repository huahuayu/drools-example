package cn.liushiming.drools;

import cn.liushiming.drools.model.Customer;
import cn.liushiming.drools.model.Order;
import cn.liushiming.drools.model.Product;
import cn.liushiming.drools.model.Result;
import cn.liushiming.drools.service.PricingService;
import cn.liushiming.drools.common.type.CustomerType;
import cn.liushiming.drools.common.type.PaymentMethod;
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
        alicePrice();
        bobPrice();
        evaPrice();
        frankPrice();
    }

    @Test
    public void alicePrice(){
        // alice, vip， buy iphone，price $1000, use wepay
        Order order = new Order(1,new Customer("alice", CustomerType.VIP),new Product("iphone",1000.00f), PaymentMethod.WEPAY);
        Result result = pricingService.getTheResult(order);
        System.out.println("alice price: " + result.getFinalPrice());
        assertEquals("order1 price is wrong",  new Float(1000.00f * 0.8 - 5),result.getFinalPrice());
    }

    @Test
    public void bobPrice(){
        // bob, ordinary customer，buy macbook pro，price $2000, use credit card
        Order order = new Order(2,new Customer("bob",CustomerType.ORDINARY),new Product("macbook pro",2000.00f), PaymentMethod.CREDITCARD);
        Result result = pricingService.getTheResult(order);
        System.out.println("bob price: " + result.getFinalPrice());
        assertEquals("bob price is wrong",new Float(2000.00f * 0.9 - 0),result.getFinalPrice());
    }

    @Test
    public void evaPrice(){
        // eva, vvip，buy mouse，price $99, use alipay
        Order order = new Order(3,new Customer("eva",CustomerType.VVIP),new Product("mouse",98.00f), PaymentMethod.ALIPAY);
        Result result = pricingService.getTheResult(order);
        System.out.println("eva price: " + result.getFinalPrice());
        assertEquals("eva price is wrong",new Float(98.00f * 0.7 - 0),result.getFinalPrice());
    }

    @Test
    public void frankPrice(){
        // frank, vvip, buy airpod, price $200, use alipay
        Order order = new Order(4,new Customer("frank",CustomerType.VVIP),new Product("airpod",200.00f), PaymentMethod.ALIPAY);
        Result result = pricingService.getTheResult(order);
        System.out.println("frank price: " + result.getFinalPrice());
        assertEquals("frank price is wrong",new Float(200.00f * 0.7 - 10),result.getFinalPrice());
    }

}
