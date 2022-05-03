package com.icloud.refactoring._16_temporary_field._01_introduce_special_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerServiceTest {

    CustomerService customerService = new CustomerService();
    Customer unknown = new Customer("unknown", null, null);

    BillingPlan twosomBillingPlan = new BillingPlan();
    Customer twosom = new Customer("twosom", twosomBillingPlan, new PaymentHistory(1));

    @Test
    void customerName() {
        String unknownCustomerName = customerService.customerName(new Site(unknown));
        assertEquals("occupant", unknownCustomerName);

        String customer = customerService.customerName(new Site(twosom));
        assertEquals("twosom", customer);
    }

    @Test
    void billingPlan() {
        assertTrue(customerService.billingPlan(new Site(unknown)) instanceof BasicBillingPlan);

        assertEquals(twosomBillingPlan, customerService.billingPlan(new Site(twosom)));
    }

    @Test
    void weeksDelinquent() {
        assertEquals(1, customerService.weeksDelinquent(new Site(twosom)));
        assertEquals(0, customerService.weeksDelinquent(new Site(unknown)));
    }

}