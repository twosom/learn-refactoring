package com.icloud.refactoring._24_comments._01_introduce_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void setDiscountRate() {
        Customer customer = new Customer();
        assertThrows(IllegalArgumentException.class, () -> {
            customer.setDiscountRate(-10d);
        });
    }

}