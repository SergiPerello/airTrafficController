package com.sergames;

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

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row && col == that.col;
    }
    */
}
