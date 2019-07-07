package com.defang.drools.model;

public class Payment {
    // 1-creditCard, 2-wepay, 3-alipay
    private String name;

    public Payment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
