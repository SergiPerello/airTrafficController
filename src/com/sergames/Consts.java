package com.sergames;

import com.sergames.models.Coordinates;

public class Consts {
    //GameConfigurations
    public static final int maxPlanes = 10;
    public static final int maxLandingTrackPlanes = 1;
    public static final Coordinates landingTrack = new Coordinates(100, 100, 0);


    //Regular Expressions
    public static final String towerMenuOptions = "[1-5]";
    public static final String planeMenuOptions = "[1-8]";
    public static final String planeTypeMenuOptions = "[1-2]";
    public static final String maxGridPosition = "([0-9][0-9]{0,2}|1000)"; //[0-1000]

    //Menus
    public static final String towerMenu =
            "1- Afegir un avió a l’espai aeri\n" +
                    "2- Gestionar un avió de l’espai Aeri\n" +
                    "3- Mostrar L’espai Aeri actual\n" +
                    "4- Xifrar els avions de combat\n" +
                    "5- Desxifrar els avions de combat";
    public static final String planeTypeMenu =
            "Chose between two airplane types:\n" + "1-Commercial\n" + "2-Military";
    //Table
    public static final String id = "ID";
    public static final String type = "Type";
    public static final String brand = "Brand";
    public static final String plate = "Plate";
    public static final String x = "X";
    public static final String y = "Y";
    public static final String z = "Z";
    public static final String orientation = "Orientation";
    public static final String speed = "Speed";
    public static final String engine = "Engine";
    public static final String undercarriage = "Undercarriage";
    public static final String on = "On";
    public static final String off = "Off";
    public static final String empty = "";
    public static final String encrypted = "ENCRYPTED";

    //Encryption
    public static final String location = "hashes/";
    public static final String hashExtension = ".hash";
    //Verbose
    public static final String height = "height";
    public static final String engineOn = "Engine is now on";
    public static final String engineOff = "Engine is now off";
    public static final String undercarriageIn = "Undercarriage is now in";
    public static final String undercarriageOut = "Undercarriage is now out";
    public static final String row = "row";
    public static final String col = "col";

    public static final String notValidOption = "Not valid option!";
    public static final String setBrand = "Write the brand: ";
    public static final String setLicensePlate = "Write the license plate: ";
    public static final String commercialPlaneCreated = "Commercial airplane created on the landing track";
    public static final String militaryPlaneCreated = "Military airplane created on the landing track";
    public static final String planeNotCreatedError = "Plane not created due to an error";
    public static final String noPlanesCreated = "You haven't created any airplane yet";
    public static final String noMilitaryPlanesToEncrypt = "You don't have any military airplane to encrypt";
    public static final String noMilitaryPlanesToDecrypt = "You don't have any military airplane to decrypt";
    public static final String noMorePlanes = "More planes aren't allowed";
    public static final String listPlanes = "Listing all available airplanes...";
    public static final String listMilitaryPlanesEncrypt = "Listing all available military airplanes to encrypt...";
    public static final String listMilitaryPlanesDecrypt = "Listing all available military airplanes to decrypt...";
    public static final String chosePlane = "Choose an airplane by it's ID: ";
    public static final String setPlaneSpeed = "Set new speed: ";
    public static final String setPlaneHeight = "Set new height: ";
    public static final String planeIsOnTheFloor = "Invalid action, plane is on the floor";
    public static final String setPlaneOrientation = "Set new orientation: ";
    public static final String setPlaneRow = "Set new position, row: ";
    public static final String setPlaneCol = "Set new position, col: ";
    public static final String turnOnEngine = "Turn the engine on before doing something else";
    public static final String somethingWentWrong = "Something went wrong";
    public static final String fileNotFound = "File not found!";
    public static final String commercialNoShoot = "Commercial planes can't shoot";
    public static final String landingTrackFull = "Landing track is full";


    public static String planeMenu(boolean engine, boolean undercarriage) {
        String msg = "";
        int i = 1;
        msg += !engine ? i++ + "- Encendre motors\n" : i++ + "- Apagar motors\n";
        msg += i++ + "- Modificar velocitat\n" +
                i++ + "- Modificar alçada\n";
        msg += !undercarriage ? i++ + "- Baixar tren d’aterratge\n" : i++ + "- Pujar tren d’aterratge\n";
        msg += i++ + "- Modificar orientació\n" +
                i++ + "- Modificar posició\n" +
                i++ + "- Disparar avió enemic\n" +
                i + "- Sortir";
        return msg;
    }

    public static String planeModification(String part, int value) {
        return "New " + part.toLowerCase() + " is " + value;
    }

    public static String planeModification(String part, String part2, int value, int value2) {
        return "New values are " + part.toLowerCase() + ":" + value + " " + part2 + ":" + value2;
    }

    /*DATA CONSULTED
    https://beginnersbook.com/2013/05/method-overloading/
    https://stackoverflow.com/questions/1998544/method-has-the-same-erasure-as-another-method-in-type
    https://stackoverflow.com/questions/13134983/liststring-to-arrayliststring-conversion-issue/13135032
    */
}
