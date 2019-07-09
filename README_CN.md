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

## QuickStart
### 克隆项目
git clone https://github.com/huahuayu/drools.git

### 导入项目
使用Intellij idea或者Eclipse打开项目，下载pom.xml中的依赖   

### 执行测试
[DroolsTest.java](https://github.com/huahuayu/drools/blob/master/src/test/java/com/huahuayu/drools/DroolsTest.java)  
``` java
public class DroolsTest {

    @Autowired
    private PricingService pricingService;

    @Test
    public void getPriceTest() {
        // alice, 会员，购买iphoneXR，价格$1000, 使用微信支付  
        Order order1 = new Order(1,new Customer("alice","2"),new Product("iphoneXR",1000.00f), new Payment("wepay"));
        // bob, 普通客户，购买macbook pro，价格$2000, 使用信用卡支付  
        Order order2 = new Order(2,new Customer("bob","1"),new Product("macbook pro",2000.00f), new Payment("creditCard"));
        // eva, 高级会员，购买鼠标，价格$99, 使用支付宝支付  
        Order order3 = new Order(3,new Customer("eva","3"),new Product("mouse",99.00f), new Payment("alipay"));
        // frank, 高级会员，购买airpod，价格$200, 使用支付宝支付
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
```

**测试结果**    
```
Result(order=Order(orderId=1, customer=Customer(name=alice, type=2), product=Product(name=iphoneXR, price=1000.0), payment=Payment(name=wepay)), discount=0.8, reduction=5.0, finalPrice=800.0)
Result(order=Order(orderId=2, customer=Customer(name=bob, type=1), product=Product(name=macbook pro, price=2000.0), payment=Payment(name=creditCard)), discount=0.9, reduction=null, finalPrice=1800.0)
Result(order=Order(orderId=3, customer=Customer(name=eva, type=3), product=Product(name=mouse, price=99.0), payment=Payment(name=alipay)), discount=0.7, reduction=null, finalPrice=69.299995)
Result(order=Order(orderId=4, customer=Customer(name=frank, type=3), product=Product(name=airpod, price=200.0), payment=Payment(name=alipay)), discount=0.7, reduction=10.0, finalPrice=140.0)
```

## 未来拓展 
使用更多的规则组合进行定价，如：  
1. 产品类别（电器、图书、母婴）  
1. 产品归属 (自营还是第三方)  
1. 收货地址 (决定运费)
1. 促销组合减价（如：A充电器+B充电线组合购买，减5元）   
1. 按活动/节日减价(如6.18)   
