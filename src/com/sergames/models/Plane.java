package com.sergames.models;

import com.sergames.Consts;

public abstract class Plane {
    private String brand;
    private String licensePlate;
    private Coordinates coordinate;
    private int orientation;
    private boolean engine;
    private int speed;
    private boolean undercarriage;
    private Type type;

    public Plane(String brand, String licensePlate, Type type) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.coordinate = Consts.landingTrack;
        this.engine = false;
        this.speed = 0;
        this.undercarriage = true;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public boolean getEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public boolean getUndercarriage() {
        return undercarriage;
    }

    public void setUndercarriage(boolean undercarriage) {
        this.undercarriage = undercarriage;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation % 360;
    }

    public void turnOnEngine() {
        engine = true;
    }

    public void turnOffEngine() {
        engine = false;
    }

    public void showUndercarriage() {
        undercarriage = true;
    }

    public void hideUndercarriage() {
        undercarriage = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //TODO: limitar velocitat segons tipus de avió
}
