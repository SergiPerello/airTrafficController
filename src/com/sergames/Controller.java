package com.sergames;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sergames.Consts.*;

public class Controller {
    private ArrayList<Airplane> planes = new ArrayList<>();

    public Controller() {
        start();
    }

    private void start() {
        while (true) {
            towerActions(Integer.parseInt(askOptionToUser(towerMenuOptions, towerMenu, notValidOption)));
        }
    }

    private void towerActions(int option) {
        switch (option) {
            case 1: //Add plane
                createPlane(Integer.parseInt(askOptionToUser(planeTypeMenuOptions, planeTypeMenu, notValidOption)));
                //TODO: check if landing track is occupied
                break;
            case 2: //Manage plane
                if (planes.size() != 0) planeActions();
                else System.out.println(noPlanesCreated);
                break;
            case 3: //Show planes
                break;
            case 4: //encrypt military planes
                break;
            case 5: //decrypt military planes
                break;
        }
    }

    private void planeActions() {
        boolean exit = false;
        int i = selectPlane();
        while (!exit) {
            int option = Integer.parseInt(askOptionToUser(planeMenuOptions, planeMenu(planes.get(i).getEngine(), planes.get(i).getUndercarriage()), notValidOption));
            if ((option >= 2 && option <= 6) && !planes.get(i).getEngine()) {
                System.out.println(turnOnEngine);
            } else {
                switch (option) {
                    case 1:
                        if (!planes.get(i).getEngine()) planes.get(i).turnOnEngine();
                        else planes.get(i).turnOffEngine();
                        break;
                    case 2:
                        int speed = Integer.parseInt(askOptionToUser(setPlaneSpeed));
                        planes.get(i).setSpeed(speed);
                        break;
                    case 3:
                        int height = Integer.parseInt(askOptionToUser(setPlaneHeight));
                        planes.get(i).getCoordinate().setHeight(height);
                        break;
                    case 4:
                        if (planes.get(i).getCoordinate().getHeight() != 0) {
                            if (!planes.get(i).getUndercarriage()) planes.get(i).showUndercarriage();
                            else planes.get(i).hideUndercarriage();
                        } else System.out.println(planeIsOnTheFloor);
                        break;
                    case 5:
                        int orientation = Integer.parseInt(askOptionToUser(setPlaneOrientation));
                        planes.get(i).setOrientation(orientation);
                        break;
                    case 6:
                        int row = Integer.parseInt(askOptionToUser(maxGridPosition, setPlaneRow, notValidOption));
                        int col = Integer.parseInt(askOptionToUser(maxGridPosition, setPlaneCol, notValidOption));
                        planes.get(i).getCoordinate().setPosition(row, col);
                        break;
                    case 7:
                        exit = true;
                        break;
                }
            }
            //TODO: Print value after a modification
            //TODO: Plane can be on 0 height with hidden undercarriage and not exploding
        }
    }

    private void createPlane(int planeType) {
        String licensePlate = askOptionToUser(planeLicensePlate);
        if (planeType == 1) { //Commercial
            planes.add(new CommercialAirplane(licensePlate));
            System.out.println(commercialPlaneCreated);
        } else if (planeType == 2) { //Military
            planes.add(new MilitaryAirplane(licensePlate));
            System.out.println(militaryPlaneCreated);
        } else System.out.println(planeNotCreatedError);
    }

    private int selectPlane() {
        int i = 1;
        System.out.println(listPlanes);
        String choosePlaneMenuOptions = "[1-" + planes.size() + "]";
        for (Airplane a : this.planes) {
            System.out.println(i + "- " + a.getLicensePlate());
            i++;
        }
        return Integer.parseInt(askOptionToUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }

    private String askOptionToUser(String textToDisplay) {
        System.out.println(textToDisplay);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private String askOptionToUser(String pattern, String textToDisplay, String invalidInput) {
        System.out.println(textToDisplay);
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (!answer.matches(pattern)) {
            System.out.println(invalidInput);
            answer = askOptionToUser(pattern, textToDisplay, invalidInput);
        }
        return answer;
    }
}
