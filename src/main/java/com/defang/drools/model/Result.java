package com.defang.drools.model;

public class Result {
    private Order order;
    private Float discount;
    private Float reduction;
    private Float finalPrice;

    public Result(Order order){
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Result{" +
                "order=" + order +
                ", discount=" + discount +
                ", reduction=" + reduction +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
