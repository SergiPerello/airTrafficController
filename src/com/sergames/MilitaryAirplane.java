package com.sergames;

public class MilitaryAirplane extends Airplane {
    private Missile[] missiles;
    private int maxRange;


    public MilitaryAirplane(String licensePlate) {
        super(licensePlate);
    }
}
