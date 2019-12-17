package com.sergames;

public abstract class Airplane {
    private String licensePlate;
    private Coordinates coordinate;
    private Orientation orientation;
    private boolean engine;
    private int speed;
    private boolean undercarriage;
    private enum Orientation {up, down, right, left}

    public Airplane(String licensePlate) {
        this.licensePlate = licensePlate;
        this.coordinate = Consts.landingTrack;
        this.engine = false;
        this.speed = 0;
        this.undercarriage = true;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public boolean getEngine() {
        return engine;
    }
    public boolean getUndercarriage() {
        return undercarriage;
    }
    public Coordinates getCoordinate() {
        return coordinate;
    }
    public void turnOnEngine() {
        engine = true;
    }
    public void turnOffEngine() {
        engine = false;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void goUp() {
        this.coordinate.setHeight(this.coordinate.getHeight() + 10);
    }
    public void goDown() {
        this.coordinate.setHeight(this.coordinate.getHeight() - 10);
    }
    public void showUndercarriage() {
        undercarriage = true;
    }
    public void hideUndercarriage() {
        undercarriage = false;
    }

    //TODO: limitar velocitat segons tipus de avió
    //TODO: modul de 360 a setRumb()

}

