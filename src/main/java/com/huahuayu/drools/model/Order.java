package com.huahuayu.drools.model;

import lombok.Data;


@Data
public class Order {
    private Integer orderId;
    private Customer customer;
    private Product product;
    private Payment payment;

    public Order(Integer orderId, Customer customer, Product product, Payment payment) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.payment = payment;
    }
}
