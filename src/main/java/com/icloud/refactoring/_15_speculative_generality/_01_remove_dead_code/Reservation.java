package com.icloud.refactoring._15_speculative_generality._01_remove_dead_code;

import java.time.LocalDateTime;

public class Reservation {

    private final LocalDateTime from;

    private final LocalDateTime to;

    private LocalDateTime alarm;

    public Reservation(String title, LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public void setAlarmBefore(int minutes) {
        this.alarm = this.from.minusMinutes(minutes);
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }
}
