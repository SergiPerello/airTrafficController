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
                        if (!planes.get(i).getEngine()) {
                            planes.get(i).turnOnEngine();
                            System.out.println(engineOn);
                        } else {
                            planes.get(i).turnOffEngine();
                            System.out.println(engineOff);
                        }
                        break;
                    case 2:
                        int speedValue = Integer.parseInt(askOptionToUser(setPlaneSpeed));
                        planes.get(i).setSpeed(speedValue);
                        System.out.println(planeModification(speed, speedValue));
                        break;
                    case 3:
                        int heightValue = Integer.parseInt(askOptionToUser(setPlaneHeight));
                        planes.get(i).getCoordinate().setHeight(heightValue);
                        System.out.println(planeModification(height, heightValue));
                        break;
                    case 4:
                        if (planes.get(i).getCoordinate().getHeight() != 0) {
                            if (!planes.get(i).getUndercarriage()) {
                                planes.get(i).showUndercarriage();
                                System.out.println(undercarriageOut);
                            } else {
                                planes.get(i).hideUndercarriage();
                                System.out.println(undercarriageIn);
                            }
                        } else System.out.println(planeIsOnTheFloor);
                        break;
                    case 5:
                        int orientationValue = Integer.parseInt(askOptionToUser(setPlaneOrientation));
                        planes.get(i).setOrientation(orientationValue);
                        System.out.println(planeModification(orientation, planes.get(i).getOrientation()));
                        break;
                    case 6:
                        int rowValue = Integer.parseInt(askOptionToUser(maxGridPosition, setPlaneRow, notValidOption));
                        int colValue = Integer.parseInt(askOptionToUser(maxGridPosition, setPlaneCol, notValidOption));
                        planes.get(i).getCoordinate().setPosition(rowValue, colValue);
                        System.out.println(planeModification(row, col, rowValue, colValue));
                        break;
                    case 7:
                        exit = true;
                        break;
                }
            }
            updatePlaneState(i);
        }
    }

    private void updatePlaneState(int plane) {
        //TODO: check when a plane has to crash
        //TODO: Plane can be on 0 height with hidden undercarriage and not exploding
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
