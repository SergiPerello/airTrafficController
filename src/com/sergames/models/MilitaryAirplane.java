package com.sergames.models;

public class MilitaryAirplane extends Plane {
    private Missile[] missiles;
    private boolean enemy;

    public MilitaryAirplane(String brand, String licensePlate, boolean enemy) {
        super(brand, licensePlate, Type.MILITARY);
        this.enemy = enemy;
    }
}
