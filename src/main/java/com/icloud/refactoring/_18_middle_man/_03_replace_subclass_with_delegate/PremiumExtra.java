package com.icloud.refactoring._18_middle_man._03_replace_subclass_with_delegate;

import java.util.List;

public class PremiumExtra {

    private final List<String> properties;

    private final double premiumFee;

    public PremiumExtra(List<String> properties, double premiumFee) {
        this.properties = properties;
        this.premiumFee = premiumFee;
    }

    public double getPremiumFee() {
        return premiumFee;
    }

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }
}
