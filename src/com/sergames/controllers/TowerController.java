package com.sergames.controllers;

import com.sergames.models.Airplane;
import com.sergames.models.CommercialAirplane;
import com.sergames.models.MilitaryAirplane;
import com.sergames.models.Tower;
import com.sergames.views.TowerView;

import static com.sergames.askUser.askUser;
import static com.sergames.views.Consts.*;

public class TowerController {
    private Tower model;
    private TowerView view;
    private int option;

    public TowerController(Tower model, TowerView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        this.option = view.TowerMenu();
    }

    public void actions() {

        switch (this.option) {
            case 1: //Add plane
                createPlane(Integer.parseInt(askUser(planeTypeMenuOptions, planeTypeMenu, notValidOption)));
                //TODO: check if landing track is occupied
                break;
            case 2: //Manage plane

                /*if (model.getPlanes().size() != 0) planeActions();
                else System.out.println(noPlanesCreated);*/
                break;
            case 3: //Show planes
                break;
            case 4: //encrypt military planes
                break;
            case 5: //decrypt military planes
                break;
        }
    }

    private void createPlane(int planeType) {
        String licensePlate = askUser(planeLicensePlate);
        if (planeType == 1) { //Commercial
            model.getPlanes().add(new CommercialAirplane(licensePlate));
            System.out.println(commercialPlaneCreated);
        } else if (planeType == 2) { //Military
            model.getPlanes().add(new MilitaryAirplane(licensePlate, false));
            System.out.println(militaryPlaneCreated);
        } else System.out.println(planeNotCreatedError);
    }
    private int selectPlane() {
        int i = 1;
        System.out.println(listPlanes);
        String choosePlaneMenuOptions = "[1-" + model.getPlanes().size() + "]";
        for (Airplane a : model.getPlanes()) {
            System.out.println(i + "- " + a.getLicensePlate());
            i++;
        }
        return Integer.parseInt(askUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }
}

