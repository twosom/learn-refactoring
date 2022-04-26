package com.icloud.refactoring._08_shotgun_surgery._02_inline_function;

public class Driver {

    private final int numberOfLateDeliveries;

    public Driver(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    public int getNumberOfLateDeliveries() {
        return this.numberOfLateDeliveries;
    }
}
