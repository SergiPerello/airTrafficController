package com.sergames.controllers;

import com.sergames.models.Airplane;
import com.sergames.views.PlaneView;

import java.util.ArrayList;

public class PlaneController {
    private Airplane model;
    private PlaneView view;

    public PlaneController(Airplane model, PlaneView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView(ArrayList<Airplane> planes) {
        view.printAirplane(planes);
    }
}
