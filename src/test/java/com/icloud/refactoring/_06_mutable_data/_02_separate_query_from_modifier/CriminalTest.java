package com.icloud.refactoring._06_mutable_data._02_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CriminalTest {

    @Test
    void findForMiscreant() {
        Criminal criminal = new Criminal();
        String found = criminal.findMiscreant(
                List.of(new Person("twosom"), new Person("Don"))
        );

        assertEquals("Don", found);
        found = criminal.findMiscreant(List.of(new Person("John"), new Person("Don")));
        assertEquals("John", found);

        found = criminal.findMiscreant(List.of(new Person("Twosom"), new Person("Hope")));
        assertEquals("", found);
    }

}