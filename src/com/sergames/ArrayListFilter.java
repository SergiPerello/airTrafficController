package com.sergames;

import com.sergames.models.Plane;

import java.util.ArrayList;

public class ArrayListFilter {

    private static ArrayList<Plane> military(ArrayList<Plane> array) {
        ArrayList<Plane> militaryPlanes = new ArrayList<>();
        for (Plane p : array) {
            if (p.isMilitary()) militaryPlanes.add(p);
        }
        return militaryPlanes;
    }

    public static ArrayList<Plane> militaryEncrypt(ArrayList<Plane> array) {
        ArrayList<Plane> a = military(array);
        ArrayList<Plane> encryptedMilitary = new ArrayList<>();
        for (Plane p : a) {
            if (p.isEncrypt()) encryptedMilitary.add(p);
        }
        return encryptedMilitary;
    }

    public static ArrayList<Plane> militaryNotEncrypt(ArrayList<Plane> array) {
        ArrayList<Plane> a = military(array);
        ArrayList<Plane> notEncryptedMilitary = new ArrayList<>();
        for (Plane p : a) {
            if (!p.isEncrypt()) notEncryptedMilitary.add(p);
        }
        return notEncryptedMilitary;
    }
}