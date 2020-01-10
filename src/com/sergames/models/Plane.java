package com.sergames.models;

import com.sergames.Consts;

import static com.sergames.Consts.landingTrack;

public abstract class Plane {
    private String brand;
    private String licensePlate;
    private Coordinates coordinate;
    private int orientation;
    private boolean engine;
    private int speed;
    private boolean undercarriage;
    private Type type;
    private boolean encrypt;

    public Plane(String brand, String licensePlate, Type type) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.coordinate = new Coordinates(landingTrack.getRow(), landingTrack.getCol(), landingTrack.getHeight());
        this.orientation = 0;
        this.engine = false;
        this.speed = 0;
        this.undercarriage = true;
        this.type = type;
        this.encrypt = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation % 360;
    }

    public boolean getEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public void turnOnEngine() {
        engine = true;
    }

    public void turnOffEngine() {
        engine = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getUndercarriage() {
        return undercarriage;
    }

    public void setUndercarriage(boolean undercarriage) {
        this.undercarriage = undercarriage;
    }

    public void showUndercarriage() {
        undercarriage = true;
    }

    public void hideUndercarriage() {
        undercarriage = false;
    }

    public Type getType() {
        return type;
    }

    public boolean isMilitary() {
        return this.type == Type.MILITARY;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }
    //TODO: limitar velocitat segons tipus de avió
}
