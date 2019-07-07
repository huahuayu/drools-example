## introduction 
A spring boot pricing service by use drools engine

## function
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


## Future plan
pricing by more condition combination, like:  
1. product category
1. production attribution(proprietary or third party)
1. delivery address(determine the ship price)
1. commodity combination sales 
1. holiday campaign in limited date
