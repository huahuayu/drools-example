package com.huahuayu.drools.model;
import lombok.Data;


@Data
public class Product {
    private String name;
    private Float price;

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}
