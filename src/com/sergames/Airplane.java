package com.sergames;

public abstract class Airplane {
    enum Orientation {up, down, right, left}

    private String licensePlate;
    private Coordinates coordinate;
    private Orientation orientation;
    private boolean engine;
    private int speed;
    private boolean undercarriage;

    public Airplane(String licensePlate) {
        this.licensePlate = licensePlate;
        this.coordinate = Consts.landingTrack;
        this.engine = false;
        this.speed = 0;
        this.undercarriage = true;
    }

    private void turnOnEngine() {
        engine = true;
    }

    private void turnOffEngine() {
        engine = false;
    }

    private void accelerate() {
        speed += 1;
    }

    private void slowDown() {
        speed -= 1;
    }

    private void showUndercarriage() {
        undercarriage = true;
    }

    private void hideUndercarriage() {
        undercarriage = false;
    }

    private void move(Orientation o) {
        switch (o) {
            case up:
                coordinate.setRow(coordinate.getRow() - 1);
                break;
            case down:
                coordinate.setRow(coordinate.getRow() + 1);
                break;
            case right:
                coordinate.setCol(coordinate.getCol() + 1);
                break;
            case left:
                coordinate.setCol(coordinate.getCol() - 1);
                break;
        }
    }


}

