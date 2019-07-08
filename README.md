[中文介绍](https://github.com/huahuayu/drools/blob/master/README_CN.md)
## Introduction 
A spring boot pricing service by use drools engine

## Function
1. discount by customer type  

| customer  | discount  |
|---|---|
| ordinary customer  | 10% off  |
| vip  | 20% off  |
| advanced vip  | 30% off  |


2. based on customer type discount, calculate reduction by payment method 

| payment method  | reduction  |
|---|---|
| creditCard  | no reduction  |
| wepay  | $5 reduction when total amount > $100  |
| alipay  | $10 reduction when total amount > $100  |


## Test
DroolsTest.java  
``` java
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
```


## Future plan
pricing by more condition combination, like:  
1. product category
1. production attribution(proprietary or third party)
1. delivery address(determine the ship price)
1. commodity combination sales 
1. holiday campaign in limited date


