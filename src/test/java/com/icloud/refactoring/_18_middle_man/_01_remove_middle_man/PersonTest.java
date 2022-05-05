package com.icloud.refactoring._18_middle_man._01_remove_middle_man;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void getManager() {
        Person nick = new Person("nick", null);
        Person twosom = new Person("twosom", new Department(nick));
        assertEquals(nick, twosom.getDepartment().getManager());
    }

}