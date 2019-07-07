package com.defang.drools.model;

public class Customer {
    private String name;
    // 1-一般客户，2-普通会员，2-高级会员
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
