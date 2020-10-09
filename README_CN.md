## 介绍 
使用drools规则引擎实现的一个电商差异化定价服务  

- 有三种不同级别的客户(普通用户、普通vip、高级vip)

- 不同级别的客户享受不同的折扣  

- 有三种不同的支付方式(信用卡、微信支付、支付宝)  

- 不同的付款方式有不同的满减金额（如支付宝满100-10元）  

## 功能
客户提交商品订单后，系统根据以下规则计算出最终的价格（这种规则经常变化，所以不适合写死在程序中，适用于drools来管理）  

**客户类型折扣**

| 客户类别  | 折扣  |
|---|---|
| 普通客户  | 9折  |
| 普通vip  | 8折  |
| 高级vip  | 7折  |


**支付方式满减**  

| 支付方式 | 优惠  |
|---|---|
| 信用卡  | 无  |
| 微信  | 满100-5元 |
| 支付宝  | 满100-10元 |

两个优惠可以叠加  

## QuickStart
### 克隆项目
``` bash
git clone https://github.com/huahuayu/drools.git
```

### 导入项目
使用Intellij idea或者Eclipse导入项目  

### 执行测试

alice, bob, eva, frank 是不同级别的客户，买了不同价格的商品，用了不同的支付方式，他们最终应该享受多少折扣、多少满减，最终支付价格是多少？

[DroolsTest.java](https://github.com/huahuayu/drools-example/blob/master/src/test/java/cn/liushiming/drools/DroolsTest.java)  

``` java
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
        assertEquals("order1 price is wrong",  new Float(1000.00f * 0.8 - 5),result.getFinalPrice());
    }

    @Test
    public void bobPrice(){
        // bob, ordinary customer，buy macbook pro，price $2000, use credit card
        Order order = new Order(2,new Customer("bob",CustomerType.ORDINARY),new Product("macbook pro",2000.00f), PaymentMethod.CREDITCARD);
        Result result = pricingService.getTheResult(order);
        assertEquals("bob price is wrong",new Float(2000.00f * 0.9 - 0),result.getFinalPrice());
    }

    @Test
    public void evaPrice(){
        // eva, vvip，buy mouse，price $99, use alipay
        Order order = new Order(3,new Customer("eva",CustomerType.VVIP),new Product("mouse",98.00f), PaymentMethod.ALIPAY);
        Result result = pricingService.getTheResult(order);
        assertEquals("eva price is wrong",new Float(98.00f * 0.7 - 0),result.getFinalPrice());
    }

    @Test
    public void frankPrice(){
        // frank, vvip, buy airpod, price $200, use alipay
        Order order = new Order(4,new Customer("frank",CustomerType.VVIP),new Product("airpod",200.00f), PaymentMethod.ALIPAY);
        Result result = pricingService.getTheResult(order);
        assertEquals("frank price is wrong",new Float(200.00f * 0.7 - 10),result.getFinalPrice());
    }

}
```

**结果**    
```
alice price: 795.0
bob price: 1800.0
eva price: 68.6
frank price: 130.0
```

### Api
提供了一个api来计算价格，可以调用接口来计算订单的最终价格  

``` java
    @PostMapping("/getPrice")
    public Result getPrice(@RequestBody Order order) {
        return pricingService.getTheResult(order);
    }
```

request  

| 字段  | 含义  | 备注  |
|---|---|---|
| orderId  | 订单id  |   |
| customer  | 客户信息  |   |
| customer.name  | 客户姓名  |   |
| customer.type  | 客户类型  | ORDINARY-普通客户，VIP-普通VIP客户，VVIP-高级VIP客户  |
| product  | 商品信息  |   |
| product.name  | 商品名  |   |
| product.price  | 商品价格  |   |
| paymentMethod  | 支付方式  | CREDITCARD-信用卡，WEPAY-微信支付，ALIPAY-支付宝  |

response

| 字段  | 含义  | 备注  |
|---|---|---|
| orderId  | 订单id  |   |
| customer  | 客户信息  |   |
| customer.name  | 客户姓名  |   |
| customer.type  | 客户类型  | ORDINARY-普通客户，VIP-VIP客户，VVIP-高级VIP客户  |
| product  | 商品信息  |   |
| product.name  | 商品名  |   |
| product.price  | 商品价格  |   |
| paymentMethod  | 支付方式  | CREDITCARD-信用卡，WEPAY-微信支付，ALIPAY-支付宝  |
| discount  | 折扣  |   |
| reduction  | 满减金额  |   |
| finalPrice  | 最终价格  |   |

示例request  
``` json
{
    "orderId": "1",
    "customer": {
        "name": "alice",
        "type": "VIP"
    },
    "product": {
        "name": "iphone",
        "price": 1000.00
    },
    "paymentMethod": "WEPAY"
}
```

示例response  

``` json
{
    "order": {
        "orderId": 1,
        "customer": {
            "name": "alice",
            "type": "VIP"
        },
        "product": {
            "name": "iphone",
            "price": 1000
        },
        "paymentMethod": "WEPAY"
    },
    "discount": 0.8,
    "reduction": 5,
    "finalPrice": 795
}
```

try it  

``` bash
curl --request POST \
  --url http://localhost:8080/getPrice \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --data '{
    "orderId": "1",
    "customer": {
        "name": "alice",
        "type": "VIP"
    },
    "product": {
        "name": "iphone",
        "price": 1000.00
    },
    "paymentMethod": "WEPAY"
}'
```



## 未来拓展 
- 使用更多的规则组合进行定价，如：  
    1. 产品类别（电器、图书、母婴）  
    2. 产品归属 (自营还是第三方)  
    3. 收货地址 (决定运费)  
    4. 促销组合减价（如：充电器+充电线组合购买，减5元）   
    5. 按活动/节日减价(如6.18)   

- 从数据库配置规则  

- 将规则缓存，提高执行速度  

- 在线测试规则  

 
