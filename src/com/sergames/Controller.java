package com.sergames;

import static com.sergames.views.Consts.*;
import static com.sergames.askUser.askUser;

public class Controller {
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
