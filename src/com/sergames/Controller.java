package com.sergames;

import com.sergames.models.CommercialAirplane;
import com.sergames.models.MilitaryAirplane;
import com.sergames.models.Plane;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sergames.Consts.*;
import static com.sergames.askUser.askUser;

public class Controller {
    //ArrayList<Plane> planes = new ArrayList<>();
    ArrayList<CommercialAirplane> commercialPlanes = new ArrayList<>();
    ArrayList<MilitaryAirplane> militaryPlanes = new ArrayList<>();

    //TODO: LicensePlane has to be more than 0 chars
    public void start() {
        File directory = new File("hashes");
        if (!directory.exists()) directory.mkdir();
        else {
            File[] files = directory.listFiles();
            for (File file : files) file.delete();
        }
        while (true) towerActions(Integer.parseInt(askUser(towerMenuOptions, towerMenu, notValidOption)));
    }

    public void towerActions(int o) {
        ArrayList<String> a = new ArrayList<>();
        if (o != 1 && commercialPlanes.size() == 0 && militaryPlanes.size() == 0) {
            System.out.println(noPlanesCreated);
        } else {
            switch (o) {
                case 1: //Add plane
                    createPlane(Integer.parseInt(askUser(planeTypeMenuOptions, planeTypeMenu, notValidOption)));
                    //TODO: check if landing track is occupied
                    break;
                case 2: //Manage plane
                    int i = selectPlane(listPlanes);

                    break;
                case 3: //Show planes
                    showPlanes();
                    break;
                case 4: //encrypt military planes
                    Predicate<MilitaryAirplane> byEncrypt = p -> !p.isEncrypt();
                    ArrayList<MilitaryAirplane> result = (ArrayList<MilitaryAirplane>) militaryPlanes.stream().filter(byEncrypt).collect(Collectors.toList());
                    if (result.size() <= 0) System.out.println(noMilitaryPlanesToEncrypt);
                    else {
                        int s = selectMilitaryPlane();
                        a = encryptPlane(s);
                    }
                    break;
                case 5: //decrypt military planes
                    byEncrypt = MilitaryAirplane::isEncrypt;
                    result = (ArrayList<MilitaryAirplane>) militaryPlanes.stream().filter(byEncrypt).collect(Collectors.toList());
                    if (result.size() <= 0) System.out.println(noMilitaryPlanesToDecrypt);
                    else {
                        int s = selectMilitaryPlane();
                        decryptPlane(result, s, a);
                    }
                    break;
            }
        }
    }

    private void createPlane(int planeType) {
        String brand = askUser(setBrand);
        String licensePlate = askUser(setLicensePlate);
        if (planeType == 1) { //Commercial
            commercialPlanes.add(new CommercialAirplane(brand, licensePlate));
            System.out.println(commercialPlaneCreated);
        } else if (planeType == 2) { //Military
            militaryPlanes.add(new MilitaryAirplane(brand, licensePlate, false));
            System.out.println(militaryPlaneCreated);
        } else System.out.println(planeNotCreatedError);
    }

    private int selectPlane(String text) {
        System.out.println(text);
        String choosePlaneMenuOptions = "[1-" + (commercialPlanes.size() + militaryPlanes.size()) + "]";
        showPlanes();
        return Integer.parseInt(askUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }

    private int selectMilitaryPlane() {
        System.out.println(listMilitaryPlanes);
        int i = showMilitaryPlanes();
        String choosePlaneMenuOptions = "[1-" + i + "]";
        return Integer.parseInt(askUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }

    private void showPlanes() {
        int i = 1;
        TableList tl = new TableList(6, "ID", "Brand", "Matrícula", "X", "Y", "Z").sortBy(0).withUnicode(true);
        for (Plane p : commercialPlanes) {
            tl.addRow(String.valueOf(i), p.getBrand(), p.getLicensePlate(),
                    String.valueOf(p.getCoordinate().getRow()),
                    String.valueOf(p.getCoordinate().getCol()),
                    String.valueOf(p.getCoordinate().getHeight()));
            i++;
        }
        for (MilitaryAirplane p : militaryPlanes) {
            if (!p.isEncrypt()) {
                tl.addRow(String.valueOf(i), p.getBrand(), p.getLicensePlate(),
                        String.valueOf(p.getCoordinate().getRow()),
                        String.valueOf(p.getCoordinate().getCol()),
                        String.valueOf(p.getCoordinate().getHeight()));
            } else {
                tl.addRow(String.valueOf(i), empty, "ENCRYPTED", empty, empty, empty);
            }
            i++;
        }
        tl.print();
    }

    private int showMilitaryPlanes() {
        int i = 1;
        TableList tl = new TableList(6, "ID", "Brand", "Matrícula", "X", "Y", "Z").sortBy(0).withUnicode(true);
        for (MilitaryAirplane p : militaryPlanes) {
            if (!p.isEncrypt()) {
                tl.addRow(String.valueOf(i), p.getBrand(), p.getLicensePlate(),
                        String.valueOf(p.getCoordinate().getRow()),
                        String.valueOf(p.getCoordinate().getCol()),
                        String.valueOf(p.getCoordinate().getHeight()));
            } else {
                tl.addRow(String.valueOf(i), empty, "ENCRYPTED", empty, empty, empty);
            }
            i++;

        }
        tl.print();
        return i;
    }

    private ArrayList<String> encryptPlane(int i) {
        String url = "hashes/" + militaryPlanes.get(i).getLicensePlate() + ".hash";
        File file = new File(url);
        if (file.exists()) file.delete();
        try (FileWriter fw = new FileWriter(url, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
            out.println(encrypt(militaryPlanes.get(i).getLicensePlate()));
        } catch (IOException e) {
            System.out.println(somethingWentWrong);
        }
        ArrayList<String> encrypted = new ArrayList<>();
        militaryPlanes.get(i).setEncrypt(true);
        encrypted.add(encrypt(militaryPlanes.get(i).getBrand()));
        encrypted.add(encrypt(militaryPlanes.get(i).getLicensePlate()));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getCoordinate().getRow())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getCoordinate().getCol())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getCoordinate().getHeight())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getOrientation())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getEngine())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getSpeed())));
        encrypted.add(encrypt(String.valueOf(militaryPlanes.get(i).getUndercarriage())));
        return encrypted;
    }

    private void decryptPlane(ArrayList<MilitaryAirplane> result, int i, ArrayList<String> encrypted) {
        String fileContent = "";
        String url = "hashes/" + result.get(i).getLicensePlate() + ".hash";
        try {
            fileContent = String.valueOf(Files.readAllBytes(Paths.get(url)));
            fileContent = fileContent.substring(0, fileContent.length() - 2);
        } catch (Exception e) {
            System.out.println(fileNotFound);
        }
        String newHash = encrypt(result.get(i).getLicensePlate());
        if (fileContent.equals(newHash)) {
            result.get(i).setEncrypt(false);
            result.get(i).setBrand(decrypt(encrypted.get(0)));
            result.get(i).setLicensePlate(decrypt(encrypted.get(1)));
            result.get(i).getCoordinate().setPosition(
                    Integer.parseInt(decrypt(encrypted.get(2))),
                    Integer.parseInt(decrypt(encrypted.get(3))));
            result.get(i).getCoordinate().setHeight(Integer.parseInt(decrypt(encrypted.get(4))));
            result.get(i).setOrientation(Integer.parseInt(decrypt(encrypted.get(5))));
            result.get(i).setEngine(Boolean.parseBoolean(decrypt(encrypted.get(6))));
            result.get(i).setSpeed(Integer.parseInt(decrypt(encrypted.get(7))));
            result.get(i).setUndercarriage(Boolean.parseBoolean(decrypt(encrypted.get(8))));
        }
    }

    private String encrypt(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    private String decrypt(String s) {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, StandardCharsets.UTF_8);
    }

    /*private void planeActions() {
        boolean exit = false;
        int i = selectPlane(listPlanes);
        while (!exit) {
            int option = Integer.parseInt(askUser(planeMenuOptions, planeMenu(planes.get(i).getEngine(), planes.get(i).getUndercarriage()), notValidOption));
            if ((option >= 2 && option <= 7) && !planes.get(i).getEngine()) {
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
    }*/
}
