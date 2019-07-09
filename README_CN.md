## 介绍 
使用drools规则引擎实现的一个电商定价服务(框架spring boot)

## 功能
客户提交商品订单后，根据不同的规则计算最终的价格  

1. 根据客户类型打折 

| 客户类别  | 折扣  |
|---|---|
| 普通客户  | 9折  |
| 普通会员  | 8折  |
| 高级会员  | 7折  |


2. 基于客户类型打折后，再基于支付方式减价  

| 支付方式 | 减价  |
|---|---|
| 信用卡  | 无减价  |
| 微信  | 满100-5元（满200也是5元） |
| 支付宝  | 满100-10元 |

## 测试
`src/test/java/com.huahuayu.drools/DroolsTest.java`  
``` java
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
```

**Result**    
```
Result(order=Order(orderId=1, customer=Customer(name=alice, type=2), product=Product(name=iphoneXR, price=1000.0), payment=Payment(name=wepay)), discount=0.8, reduction=5.0, finalPrice=995.0)
Result(order=Order(orderId=2, customer=Customer(name=bob, type=1), product=Product(name=macbook pro, price=2000.0), payment=Payment(name=creditCard)), discount=0.9, reduction=null, finalPrice=1800.0)
Result(order=Order(orderId=3, customer=Customer(name=eva, type=3), product=Product(name=mouse, price=99.0), payment=Payment(name=alipay)), discount=0.7, reduction=null, finalPrice=69.299995)
Result(order=Order(orderId=3, customer=Customer(name=frank, type=4), product=Product(name=airpod, price=200.0), payment=Payment(name=alipay)), discount=null, reduction=10.0, finalPrice=190.0)
```

## 拓展 
使用更多的规则组合进行定价，如：  
1. 产品类别（电器、图书、母婴）  
1. 产品归属 (自营还是第三方)  
1. 收货地址 (决定运费)
1. 促销组合减价（如：A充电器+B充电线组合购买，减5元）   
1. 按活动/节日减价(如6.18)   
