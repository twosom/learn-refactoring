package com.icloud.refactoring._17_message_chain._01_hide_delegate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void manager() {
        Person twosom = new Person("twosom");
        Person nick = new Person("nick");
        twosom.setDepartment(new Department("m365deploy", nick));

        Person manager = twosom.getManager();
        assertEquals(nick, manager);
    }

}