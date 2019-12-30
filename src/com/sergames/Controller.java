package com.sergames;

import com.sergames.models.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.sergames.ArrayListFilter.*;
import static com.sergames.Consts.*;
import static com.sergames.askUser.askUser;

public class Controller {
    ArrayList<Plane> planes = new ArrayList<>();
    ArrayList<ArrayList<String>> encryptedPlanes = new ArrayList<>();

    //TODO: LicensePlane has to be more than 0 chars
    public void start() {
        File directory = new File("hashes");
        if (!directory.exists()) directory.mkdir();
        else {
            File[] files = directory.listFiles();
            assert files != null;
            for (File file : files) file.delete();
        }
        while (true) towerActions(Integer.parseInt(askUser(towerMenuOptions, towerMenu, notValidOption)));
    }

    public void towerActions(int o) {
        if (o != 1 && planes.size() == 0) System.out.println(noPlanesCreated);
        else {
            switch (o) {
                case 1: //Add plane
                    createPlane(Integer.parseInt(askUser(planeTypeMenuOptions, planeTypeMenu, notValidOption)));
                    //TODO: check if landing track is occupied
                    break;
                case 2: //Manage plane
                    planeActions();
                    break;
                case 3: //Show planes
                    showPlanes(listPlanes, planes);
                    break;
                case 4: //encrypt military planes
                    ArrayList<Plane> militaryNotEncrypt = militaryNotEncrypt(planes);
                    if (militaryNotEncrypt.size() <= 0) System.out.println(noMilitaryPlanesToEncrypt);
                    else {
                        int s = selectPlane(listMilitaryPlanesEncrypt, militaryNotEncrypt);
                        encryptedPlanes.add(encryptPlane(s, militaryNotEncrypt));
                    }
                    break;
                case 5: //decrypt military planes
                    ArrayList<Plane> militaryEncrypt = militaryEncrypt(planes);
                    if (militaryEncrypt.size() <= 0) System.out.println(noMilitaryPlanesToDecrypt);
                    else {
                        int s = selectPlane(listMilitaryPlanesDecrypt, militaryEncrypt);
                        decryptPlane(militaryEncrypt, s, encryptedPlanes.get(s));
                    }
                    break;
            }
        }
    }

    private void createPlane(int planeType) {
        if (checkLandingTrack()) {
            if (planes.size() >= maxPlanes) System.out.println(noMorePlanes);
            else {
                String brand = askUser(setBrand);
                String licensePlate = askUser(setLicensePlate);
                if (planeType == 1) { //Commercial
                    planes.add(new CommercialAirplane(brand, licensePlate));
                    System.out.println(commercialPlaneCreated);
                } else if (planeType == 2) { //Military
                    planes.add(new MilitaryAirplane(brand, licensePlate, false));
                    System.out.println(militaryPlaneCreated);
                } else System.out.println(planeNotCreatedError);
            }
        } else System.out.println(landingTrackFull);
    }

    private boolean checkLandingTrack() {
        for (Plane p : planes) {
            Coordinates c = new Coordinates(p.getCoordinate().getRow(), p.getCoordinate().getCol(), p.getCoordinate().getHeight());
            if (c.equals(landingTrack)) {
                ArrayList<Plane> array = new ArrayList<>();
                array.add(p);
                if (array.size() < maxLandingTrackPlanes) return true;
            }
        }
        return false;
    }

    private int selectPlane(String text, ArrayList<Plane> array) {
        String choosePlaneMenuOptions = "[1-" + array.size() + "]";
        showPlanes(text, array);
        return Integer.parseInt(askUser(choosePlaneMenuOptions, chosePlane, notValidOption)) - 1;
    }

    private void planeActions() {
        boolean exit = false;
        ArrayList<Plane> notEncrypt = notEncrypt(planes);
        int i = selectPlane(listPlanes, notEncrypt);
        while (!exit) {
            int option = Integer.parseInt(askUser(planeMenuOptions, planeMenu(notEncrypt.get(i).getEngine(), notEncrypt.get(i).getUndercarriage()), notValidOption));
            if ((option >= 2 && option <= 7) && !notEncrypt.get(i).getEngine()) {
                System.out.println(turnOnEngine);
            } else {
                switch (option) {
                    case 1:
                        if (!notEncrypt.get(i).getEngine()) {
                            notEncrypt.get(i).turnOnEngine();
                            System.out.println(engineOn);
                        } else {
                            notEncrypt.get(i).turnOffEngine();
                            System.out.println(engineOff);
                        }
                        break;
                    case 2:
                        int speedValue = Integer.parseInt(askUser(setPlaneSpeed));
                        notEncrypt.get(i).setSpeed(speedValue);
                        System.out.println(planeModification(speed, speedValue));
                        break;
                    case 3:
                        int heightValue = Integer.parseInt(askUser(setPlaneHeight));
                        notEncrypt.get(i).getCoordinate().setHeight(heightValue);
                        System.out.println(planeModification(height, heightValue));
                        break;
                    case 4:
                        if (notEncrypt.get(i).getCoordinate().getHeight() != 0) {
                            if (!notEncrypt.get(i).getUndercarriage()) {
                                notEncrypt.get(i).showUndercarriage();
                                System.out.println(undercarriageOut);
                            } else {
                                notEncrypt.get(i).hideUndercarriage();
                                System.out.println(undercarriageIn);
                            }
                        } else System.out.println(planeIsOnTheFloor);
                        break;
                    case 5:
                        int orientationValue = Integer.parseInt(askUser(setPlaneOrientation));
                        notEncrypt.get(i).setOrientation(orientationValue);
                        System.out.println(planeModification(orientation, notEncrypt.get(i).getOrientation()));
                        break;
                    case 6:
                        int rowValue = Integer.parseInt(askUser(maxGridPosition, setPlaneRow, notValidOption));
                        int colValue = Integer.parseInt(askUser(maxGridPosition, setPlaneCol, notValidOption));
                        notEncrypt.get(i).getCoordinate().setPosition(rowValue, colValue);
                        System.out.println(planeModification(row, col, rowValue, colValue));
                        break;
                    case 7:
                        if (planes.get(i).getType() == Type.COMMERCIAL) System.out.println(commercialNoShoot);
                        else {
                            //TODO: Shoot
                        }
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

    private void showPlanes(String text, List<Plane> arrayList) {
        System.out.println(text);
        int i = 1;
        TableList tl = new TableList(11, id, type, brand, plate, x, y, z, orientation, speed, engine, undercarriage).sortBy(0).withUnicode(true);
        for (Plane p : arrayList) {
            if (!p.isEncrypt()) {
                String engine = p.getEngine() ? on : off;
                String undercarriage = p.getEngine() ? on : off;
                tl.addRow(String.valueOf(i),
                        String.valueOf(p.getType()),
                        p.getBrand(),
                        p.getLicensePlate(),
                        String.valueOf(p.getCoordinate().getRow()),
                        String.valueOf(p.getCoordinate().getCol()),
                        String.valueOf(p.getCoordinate().getHeight()),
                        String.valueOf(p.getOrientation()),
                        String.valueOf(p.getSpeed()),
                        engine, undercarriage);
            } else {
                tl.addRow(String.valueOf(i), empty, encrypted, empty, empty, empty);
            }
            i++;
        }
        tl.print();
    }

    private void CreateEncryptFile(String licensePlate) {
        String url = location + licensePlate + hashExtension;
        File file = new File(url);
        if (file.exists()) file.delete();
        try (FileWriter fw = new FileWriter(url, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
            out.println(encrypt(licensePlate));
        } catch (IOException e) {
            System.out.println(somethingWentWrong);
        }
    }

    private ArrayList<String> encryptPlane(int i, ArrayList<Plane> arrayList) {
        String licensePlate = arrayList.get(i).getLicensePlate();
        CreateEncryptFile(licensePlate);
        ArrayList<String> encrypted = new ArrayList<>();
        arrayList.get(i).setEncrypt(true);
        encrypted.add(encrypt(licensePlate));
        encrypted.add(encrypt(arrayList.get(i).getBrand()));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getCoordinate().getRow())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getCoordinate().getCol())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getCoordinate().getHeight())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getOrientation())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getEngine())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getSpeed())));
        encrypted.add(encrypt(String.valueOf(arrayList.get(i).getUndercarriage())));
        return encrypted;
    }

    private String ReadEncryptFile(String licensePlate) {
        String fContent = empty;
        String url = location + licensePlate + hashExtension;
        try {
            fContent = new String(Files.readAllBytes(Paths.get(url)));
            fContent = fContent.substring(0, fContent.length() - 2);
        } catch (Exception e) {
            System.out.println(fileNotFound);
        }
        return fContent;
    }

    private void decryptPlane(ArrayList<Plane> array, int i, ArrayList<String> encrypted) {
        String licensePlate = array.get(i).getLicensePlate();
        String fileContent = ReadEncryptFile(licensePlate);
        if (fileContent.equals(encrypt(licensePlate))) {
            array.get(i).setEncrypt(false);
            array.get(i).setLicensePlate(decrypt(encrypted.get(0)));
            array.get(i).setBrand(decrypt(encrypted.get(1)));
            array.get(i).getCoordinate().setPosition(
                    Integer.parseInt(decrypt(encrypted.get(2))),
                    Integer.parseInt(decrypt(encrypted.get(3))));
            array.get(i).getCoordinate().setHeight(Integer.parseInt(decrypt(encrypted.get(4))));
            array.get(i).setOrientation(Integer.parseInt(decrypt(encrypted.get(5))));
            array.get(i).setEngine(Boolean.parseBoolean(decrypt(encrypted.get(6))));
            array.get(i).setSpeed(Integer.parseInt(decrypt(encrypted.get(7))));
            array.get(i).setUndercarriage(Boolean.parseBoolean(decrypt(encrypted.get(8))));
        }
    }

    private String encrypt(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    private String decrypt(String s) {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, StandardCharsets.UTF_8);
    }
}
