package com.icloud.refactoring._07_divergent_change._01_split_phase;

public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        PriceData priceData = calculatePriceData(product, quantity);
        return applyShippingPrice(priceData, shippingMethod);
    }

    private PriceData calculatePriceData(Product product, int quantity) {
        final double basePrice = product.basePrice() * quantity;
        return new PriceData(basePrice, getDiscount(product, quantity), quantity);
    }

    private double getDiscount(Product product, int quantity) {
        return Math.max(quantity - product.discountThreshold(), 0) * product.basePrice() * product.discountRate();
    }

    private double applyShippingPrice(PriceData priceData, ShippingMethod shippingMethod) {
        final double shippingPerCase = getShippingPerCase(shippingMethod, priceData.basePrice());
        final double shippingCost = priceData.quantity() * shippingPerCase;
        return priceData.basePrice() - priceData.discount() + shippingCost;
    }

    private double getShippingPerCase(ShippingMethod shippingMethod, double basePrice) {
        return isDiscountedFee(shippingMethod, basePrice) ?
                shippingMethod.discountedFee() :
                shippingMethod.feePerCase();
    }

    private boolean isDiscountedFee(ShippingMethod shippingMethod, double basePrice) {
        return basePrice > shippingMethod.discountThreshold();
    }
}
