package com.sergames.models;

public class CommercialAirplane extends Plane {
    public CommercialAirplane(String brand, String licensePlate) {
        super(brand, licensePlate, Type.COMMERCIAL);
    }
}
