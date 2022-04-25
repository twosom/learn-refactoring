package com.icloud.refactoring._07_divergent_change._03_extract_class;

public class TelephoneNumber {
    private String areaCode;
    private String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public TelephoneNumber setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TelephoneNumber setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return this.getAreaCode() + " " + this.getNumber();
    }
}