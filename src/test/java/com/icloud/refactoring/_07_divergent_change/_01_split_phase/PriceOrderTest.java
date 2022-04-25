package com.icloud.refactoring._07_divergent_change._01_split_phase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceOrderTest {

    @Test
    void priceOrder_discountedFee() {
        PriceOrder priceOrder = new PriceOrder();
        Product product =
                new Product(10, 2, 0.5);
        ShippingMethod shippingMethod =
                new ShippingMethod(20, 1, 5);
        double price = priceOrder.priceOrder(product, 4, shippingMethod);

        // basePrice = 10 * 4 = 40
        // discount = 2 * 10 * 0.5 = 10
        // shippingPerCase = 1 (40 > 20)
        // price = 40 - 10 + 4 = 34

        assertEquals(34, price);
    }

    @Test
    void priceOrder_feePerCase() {
        PriceOrder priceOrder = new PriceOrder();
        double price = priceOrder.priceOrder(new Product(10, 2, 0.5),
                2,
                new ShippingMethod(20, 1, 5));

        // basePrice = 10 * 2 = 20
        // discount = 0 * 10 * 0.5 = 0
        // shippingPerCase = 5
        // price = 20 - 0 + 10 = 30

        assertEquals(30, price);
    }

}