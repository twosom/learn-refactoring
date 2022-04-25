package com.icloud.refactoring._06_mutable_data._04_replace_derived_variable_with_query;

public class Discount {

    private double discount;
    private final double baseTotal;

    public Discount(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public double getDiscountedTotal() {
        return this.baseTotal - this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
