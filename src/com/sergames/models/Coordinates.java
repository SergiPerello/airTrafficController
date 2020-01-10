package com.sergames.models;

public class Coordinates {

    private int row;
    private int col;
    private int height;

    public Coordinates(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        Coordinates that = (Coordinates) o;
        return this.row == that.row &&
                this.col == that.col &&
                this.height == that.height;
    }
}
