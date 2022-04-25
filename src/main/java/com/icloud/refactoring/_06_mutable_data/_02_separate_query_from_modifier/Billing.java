package com.icloud.refactoring._06_mutable_data._02_separate_query_from_modifier;

public class Billing {

    private final Customer customer;

    private final EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double totalOutstanding() {
        return customer.getInvoices().stream()
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
