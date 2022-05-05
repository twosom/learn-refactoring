package com.icloud.refactoring._18_middle_man._03_replace_subclass_with_delegate;

import java.util.List;

public class Show {

    private final List<String> properties;

    private final double price;

    public Show(List<String> properties, double price) {
        this.properties = properties;
        this.price = price;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }

    public double getPrice() {
        return price;
    }
}
