[中文介绍](https://github.com/huahuayu/drools-example/blob/master/README_CN.md)
## Introduction 
drools example in e-commerce business rules to calculate the final price to pay  

- there are different customer levels(ordinary, vip , vvip)  
- different customer level have different discount   
- there are different payment methods(creditCard, wepay, alipay)  
- different payment methods get different reduction  

## Business Rules
**discount by customer type**  

| customer  | discount  |
|---|---|
| ordinary customer  | 10% off  |
| vip  | 20% off  |
| vvip  | 30% off  |

<br>

**reduction by payment method** 

| payment method  | reduction  |
|---|---|
| creditCard  | no reduction  |
| wepay  | $5 reduction when total amount > $100  |
| alipay  | $10 reduction when total amount > $100  |

## QuickStart
### clone repo
``` bash
git clone https://github.com/huahuayu/drools.git
```

### import project
import project to Intellij idea or Eclipse

### run test
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

**Result**    
```
alice price: 795.0
bob price: 1800.0
eva price: 68.6
frank price: 130.0
```

### Api
An api is provided to calculate price, so every order gets a differentiation price  

``` java
    @PostMapping("/getPrice")
    public Result getPrice(@RequestBody Order order) {
        return pricingService.getTheResult(order);
    }
```

sample input 

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


sample output

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
