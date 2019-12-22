package com.sergames.views;

import com.sergames.models.Airplane;

import java.util.ArrayList;

public class PlaneView {
    public void printAirplane(ArrayList<Airplane> planes){
        int i = 1;
        for (Airplane a : planes) {
            printAirplane(i++,a);
        }
    }
    public void printAirplane(int i, Airplane a){
        System.out.println("Airplane"+i+":");
        System.out.println("licensePlate: " + a.getLicensePlate());
        System.out.println("engine: " + a.getEngine());
    }
}
