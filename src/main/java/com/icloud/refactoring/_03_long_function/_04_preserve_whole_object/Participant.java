package com.icloud.refactoring._03_long_function._04_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {
    public Participant(String username) {
        this(username, new HashMap<>());
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }


    double getRate(int totalNumberOfEvents) {
        long count = homework().values().stream()
                .filter(Boolean.TRUE::equals)
                .count();
        return (double) (count * 100 / totalNumberOfEvents);
    }
}
