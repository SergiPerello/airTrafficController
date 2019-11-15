package com.sergames;

import static com.sergames.UserInteraction.*;

public class Controller{
    public Controller() {
        int airTrafficControllerOption = Integer.parseInt(
            askOptionToUser(getAirTrafficControllerMenuOptions, airTrafficControllerMenu, notValidOption));

    }

    private void airTrafficControllerMenuDecider(int option){
        switch (option) {
            case 1:
                askOptionToUser()
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
