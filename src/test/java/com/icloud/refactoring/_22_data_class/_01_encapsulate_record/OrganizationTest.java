package com.icloud.refactoring._22_data_class._01_encapsulate_record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    @Test
    void name() {
        Organization organization = new Organization("twosom", "Korean");
    }

}