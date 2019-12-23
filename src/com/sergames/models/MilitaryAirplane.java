package com.sergames.models;

public class MilitaryAirplane extends Plane {
    private Missile[] missiles;
    private boolean enemy;
    private boolean encrypt;

    public MilitaryAirplane(String brand, String licensePlate, boolean enemy) {
        super(brand, licensePlate, Type.MILITARY);
        this.enemy = enemy;
        this.encrypt = false;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }
}
