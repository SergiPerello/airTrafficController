package com.sergames;

public abstract class Airplane {
    private String licensePlate;
    private Coordinates coordinate;
    enum Orientation { up, down, right, left }
    private Orientation orientation;
    private boolean engine;
    private int speed;
    private boolean undercarriage;

    public Airplane(String licensePlate, Coordinates coordinate) {
        this.licensePlate = licensePlate;
        this.coordinate = GameConfiguration.landingTrack;
        this.engine = false;
        this.speed = 0;
        this.undercarriage = true;
    }
    private void turnOnEngine(){
        engine = true;
    }
    private void turnOffEngine(){
        engine = false;
    }
    private void accelerate(){
        speed += 1;
    }
    private void slowDown(){
        speed -=1;
    }
    private void showUndercarriage(){
        undercarriage = true;
    }
    private void hideUndercarriage(){
        undercarriage = false;
    }
    private void move(Orientation o) {
        switch (o) {
            case up:
                coordinate.setRow(coordinate.getRow()-1);
                break;
            case down:
                coordinate.setRow(coordinate.getRow()+1);
                break;
            case right:
                coordinate.setCol(coordinate.getCol()+1);
                break;
            case left:
                coordinate.setCol(coordinate.getCol()-1);
                break;
        }
    }


}

