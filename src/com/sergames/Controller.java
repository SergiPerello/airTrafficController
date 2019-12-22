package com.sergames;

import com.sergames.models.CommercialAirplane;
import com.sergames.models.MilitaryAirplane;
import com.sergames.models.Plane;

import java.util.ArrayList;

import static com.sergames.Consts.*;
import static com.sergames.askUser.askUser;

public class Controller {
    ArrayList<Plane> planes = new ArrayList<>();

    public void start() {
        while (true) towerActions(Integer.parseInt(askUser(towerMenuOptions, towerMenu, notValidOption)));
    }

    public void towerActions(int o) {
        switch (o) {
            case 1: //Add plane
                createPlane(Integer.parseInt(askUser(planeTypeMenuOptions, planeTypeMenu, notValidOption)));
                //TODO: check if landing track is occupied
                break;
            case 2: //Manage plane
                if (planes.size() != 0) planeActions();
                else System.out.println(noPlanesCreated);
                break;
            case 3: //Show planes
                if (planes.size() != 0) showPlanes();
                else System.out.println(noPlanesCreated);
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
            planes.add(new CommercialAirplane(licensePlate));
            System.out.println(commercialPlaneCreated);
        } else if (planeType == 2) { //Military
            planes.add(new MilitaryAirplane(licensePlate, false));
            System.out.println(militaryPlaneCreated);
        } else System.out.println(planeNotCreatedError);
    }

    private void showPlanes() {
        int i = 1;
        TableList tl = new TableList(5, "ID", "Matrícula", "X", "Y", "Alçada").sortBy(0).withUnicode(true);
        for (Plane p : planes) {
            tl.addRow(String.valueOf(i), p.getLicensePlate(), String.valueOf(p.getCoordinate().getRow()), String.valueOf(p.getCoordinate().getCol()), String.valueOf(p.getCoordinate().getHeight()));
            i++;
        }
        tl.print();
    }

    private int selectPlane() {
        System.out.println(listPlanes);
        String choosePlaneMenuOptions = "[1-" + planes.size() + "]";
        showPlanes();
        return Integer.parseInt(askUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }

    private void planeActions() {
        boolean exit = false;
        int i = selectPlane();
        while (!exit) {
            int option = Integer.parseInt(askUser(planeMenuOptions, planeMenu(planes.get(i).getEngine(), planes.get(i).getUndercarriage()), notValidOption));
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
                        int speedValue = Integer.parseInt(askUser(setPlaneSpeed));
                        planes.get(i).setSpeed(speedValue);
                        System.out.println(planeModification(speed, speedValue));
                        break;
                    case 3:
                        int heightValue = Integer.parseInt(askUser(setPlaneHeight));
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
                        int orientationValue = Integer.parseInt(askUser(setPlaneOrientation));
                        planes.get(i).setOrientation(orientationValue);
                        System.out.println(planeModification(orientation, planes.get(i).getOrientation()));
                        break;
                    case 6:
                        int rowValue = Integer.parseInt(askUser(maxGridPosition, setPlaneRow, notValidOption));
                        int colValue = Integer.parseInt(askUser(maxGridPosition, setPlaneCol, notValidOption));
                        planes.get(i).getCoordinate().setPosition(rowValue, colValue);
                        System.out.println(planeModification(row, col, rowValue, colValue));
                        break;
                    case 7:
                        //TODO: Shoot
                        break;
                    case 8:
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
}
