package com.icloud.refactoring._17_message_chain._01_hide_delegate;

public class Person {

    private final String name;

    private Department department;

    private Person manager;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getManager() {
//        return this.manager;
        return this.getDepartment().getManager();
    }
}
