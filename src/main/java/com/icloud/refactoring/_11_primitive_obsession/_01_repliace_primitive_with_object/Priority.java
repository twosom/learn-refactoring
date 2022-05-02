package com.icloud.refactoring._11_primitive_obsession._01_repliace_primitive_with_object;

import java.util.List;

public class Priority {

    private String value;

    private List<String> legalValues =
            List.of("low", "normal", "high", "rush");

    public Priority(String value) {
        if (this.legalValues.contains(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal value for priority " + value);
        }

    }

    @Override
    public String toString() {
        return this.value;
    }

    private int index() {
        return legalValues.indexOf(this.value);
    }

    public boolean higherThan(Priority other) {
        return this.index() > other.index();
    }


}
