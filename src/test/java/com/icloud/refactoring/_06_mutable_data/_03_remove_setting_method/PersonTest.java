package com.icloud.refactoring._06_mutable_data._03_remove_setting_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void person() {
        Person person = new Person(10);
        person.setName("hope");
        assertEquals(10, person.getId());
        assertEquals("hope", person.getName());
        person.setName("twosom");
        assertEquals("twosom", person.getName());
    }

}