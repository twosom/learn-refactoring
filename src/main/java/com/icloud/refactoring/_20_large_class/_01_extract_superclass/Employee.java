package com.icloud.refactoring._20_large_class._01_extract_superclass;

public class Employee extends Party {

    private Integer id;

    public Integer getId() {
        return id;
    }

    private double monthlyCost;

    @Override
    public double monthlyCost() {
        return this.monthlyCost;
    }
}
