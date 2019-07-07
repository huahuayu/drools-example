package com.defang.drools.model;

public class Customer {
    private String name;
    // 1-ordinary customer, 2-vip member, 3-advanced vip
    private String type;


    public Customer(){

    }

    public Customer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
