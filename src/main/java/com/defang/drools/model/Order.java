package com.defang.drools.model;

public class Order {
    private Customer customer;
    private Product product;
    private Payment payment;

    public Order(Customer customer, Product product, Payment payment) {
        this.customer = customer;
        this.product = product;
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment(){
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
