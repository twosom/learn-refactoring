package com.icloud.refactoring._11_primitive_obsession._02_replace_type_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void employeeType() {
        assertEquals("engineer", Employee.createEmployee("twosom", "engineer").getType());
        assertEquals("manager", Employee.createEmployee("twosom", "manager").getType());
        assertThrows(IllegalArgumentException.class, () -> Employee.createEmployee("twosom", "wrong type"));
    }

}