package com.icloud.refactoring._11_primitive_obsession._02_replace_type_code_with_subclasses.indirect_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void employeeTest() {
        assertEquals("Manager", new FullTimeEmployee("twosom", "manager").capitalizedType());
        assertEquals("Engineer", new FullTimeEmployee("twosom", "engineer").capitalizedType());
        assertThrows(IllegalArgumentException.class, () -> new Employee("twosom", "wrong type"));
    }

}