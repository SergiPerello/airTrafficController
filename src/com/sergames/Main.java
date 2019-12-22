package com.sergames;

import com.sergames.controllers.PlaneController;
import com.sergames.controllers.TowerController;
import com.sergames.models.Tower;
import com.sergames.views.PlaneView;
import com.sergames.views.TowerView;

public class Main {
    public static void main(String[] args) {
        Tower towerModel = new Tower();
        TowerView towerView = new TowerView();
        TowerController towerController = new TowerController(towerModel, towerView);
        towerController.updateView();
        towerController.actions();

        PlaneView planeView = new PlaneView();
        PlaneController planeController = new PlaneController(, planeView);

    }
}

