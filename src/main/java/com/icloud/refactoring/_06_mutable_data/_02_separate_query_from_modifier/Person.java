package com.icloud.refactoring._06_mutable_data._02_separate_query_from_modifier;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
