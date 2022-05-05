package com.icloud.refactoring._19_insider_trading;

import java.time.LocalDate;

public class Ticket {

    private final LocalDate purchasedDate;

    private final boolean prime;

    public Ticket(LocalDate purchasedDate, boolean prime) {
        this.purchasedDate = purchasedDate;
        this.prime = prime;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public boolean isPrime() {
        return prime;
    }

    public boolean isFastPass() {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return this.isPrime() && this.getPurchasedDate().isBefore(earlyBirdDate);
    }
}
