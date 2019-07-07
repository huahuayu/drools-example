package com.defang.drools.model;

public class Payment {
    // 信用卡、微信、支付宝
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
