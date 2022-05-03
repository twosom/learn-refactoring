package com.icloud.refactoring._16_temporary_field._01_introduce_special_case;

public class Site {

    private final Customer customer;

    public Site(Customer customer) {
        this.customer = customer.getName().equals("unknown") ?
                new UnknownCustomer() :
                customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
