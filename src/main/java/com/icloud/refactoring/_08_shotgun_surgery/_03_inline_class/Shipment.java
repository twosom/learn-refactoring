package com.icloud.refactoring._08_shotgun_surgery._03_inline_class;

public record Shipment(String shippingCompany, String trackingNumber) {

    public String getTrackingInfo() {
        return this.shippingCompany + ": " + this.trackingNumber;
    }


}
