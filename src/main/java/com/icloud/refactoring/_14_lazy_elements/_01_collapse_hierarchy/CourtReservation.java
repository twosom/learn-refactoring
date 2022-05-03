package com.icloud.refactoring._14_lazy_elements._01_collapse_hierarchy;

import java.time.LocalDateTime;

public class CourtReservation extends Reservation {

    private LocalDateTime startDateTime;

    private boolean paid;

    private String courtNumber;

}
