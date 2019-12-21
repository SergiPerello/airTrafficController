package com.sergames;

public class Consts {
    //GameConfigurations
    public static final Coordinates landingTrack = new Coordinates(100, 100, 0);
    public static final int gridSize = 1000;

    //Regular Expressions
    public static final String towerMenuOptions = "[1-5]";
    public static final String planeMenuOptions = "[1-7]";
    public static final String planeTypeMenuOptions = "[1-2]";

    //Menus
    public static final String towerMenu =
            "1- Afegir un avió a l’espai aeri\n" +
                    "2- Gestionar un avió de l’espai Aeri\n" +
                    "3- Mostrar L’espai Aeri actual\n" +
                    "4- Xifrar els avions de combat\n" +
                    "5- Desxifrar els avions de combat";
    public static final String planeTypeMenu =
            "Chose between two airplane types:\n" + "1-Commercial\n" + "2-Military";
    //Verbose
    public static final String notValidOption = "Not valid option!";
    public static final String planeLicensePlate = "Write the license plate: ";
    public static final String commercialPlaneCreated = "Commercial airplane created on the landing track";
    public static final String militaryPlaneCreated = "Military airplane created on the landing track";
    public static final String planeNotCreatedError = "Plane not created due to an error";
    public static final String noPlanesCreated = "You haven't created any airplane yet";
    public static final String listPlanes = "Listing all available airplanes...";
    public static final String chosePlane = "Choose an airplane: ";
    public static final String setPlaneSpeed = "Set new speed: ";
    public static final String setPlaneHeight = "Set new height: ";

    public static String planeMenu(boolean engine, boolean undercarriage, int height) {
        String msg = "";
        int i = 1;
        msg += !engine ? i++ + "- Encendre motors\n" : i++ + "- Apagar motors\n";
        msg += i++ + "- Modificar velocitat\n" +
                i++ + "- Modificar alçada\n";
        msg += !undercarriage ? i++ + "- Baixar tren d’aterratge\n" : i++ + "- Pujar tren d’aterratge\n";
        msg += i++ + "- Modificar rumb\n" +
                i++ + "- Modificar posició\n" +
                i++ + "- Sortir";
        return msg;
    }
}
