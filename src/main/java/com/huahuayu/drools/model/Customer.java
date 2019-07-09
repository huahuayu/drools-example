package com.huahuayu.drools.model;
import lombok.Data;

@Data
public class Customer {
    private String name;

    // 1-ordinary customer, 2-vip member, 3-advanced vip
    private String type;

    public Customer(String name, String type){
        this.name = name;
        this.type = type;
    }

}
