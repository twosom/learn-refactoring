package com.icloud.refactoring._20_large_class._01_extract_superclass;

public abstract class Party {
    private String name;

    public String getName() {
        return this.name;
    }

    public double annualCost() {
        return this.monthlyCost() * 12;
    }

    public abstract double monthlyCost();
}
