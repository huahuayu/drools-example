package com.huahuayu.drools.model;
import lombok.Data;


@Data
public class Payment {
    // 1-creditCard, 2-wepay, 3-alipay
    private String name;

    public Payment(String name) {
        this.name = name;
    }
}
