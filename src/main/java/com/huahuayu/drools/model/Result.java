package com.huahuayu.drools.model;
import lombok.Data;

@Data
public class Result {
    private Order order;
    private Float discount;
    private Float reduction;
    private Float finalPrice;

    public Result(Order order){
       this.order = order;
    }
}
