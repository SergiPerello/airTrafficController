package com.sergames.models;

public class MilitaryAirplane extends Airplane {
    private Missile[] missiles;
    private boolean enemy;

    public MilitaryAirplane(String licensePlate, boolean enemy) {
        super(licensePlate, Type.MILITARY);
        this.enemy = enemy;
    }
}
