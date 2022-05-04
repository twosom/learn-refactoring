package com.icloud.refactoring._17_message_chain._01_hide_delegate;

public class Department {

    private final String chargeCode;

    private final Person manager;

    public Department(String chargeCode, Person manager) {
        this.chargeCode = chargeCode;
        this.manager = manager;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public Person getManager() {
        return manager;
    }
}
