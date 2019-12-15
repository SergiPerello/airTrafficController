package com.sergames;

public class Consts {
    //GameConfigurations
    public static final Coordinates landingTrack = new Coordinates(100, 100, 0);
    public static final int gridSize = 1000;

    //Regular Expressions
    public static final String towerMenuOptions = "[1-5]";
    public static final String planeMenuOptions = "[1-8]";
    public static final String planeTypeMenuOptions = "[1-2]";

    //Menus
    public static final String towerMenu =
            "1- Afegir un avió a l’espai aeri\n" +
                    "2- Gestionar un avió de l’espai Aeri\n" +
                    "3- Mostrar L’espai Aeri actual\n" +
                    "4- Xifrar els avions de combat\n" +
                    "5- Desxifrar els avions de combat";

    public static String planeMenu(boolean engine, boolean undercarriage) {
        String msg = "";
        msg += !engine ? "1- Encendre motors\n" : "1- Apagar motors\n";
        msg += "2- Accelerar\n" +
                "3- Frenar\n";
        msg += !undercarriage ? "4- Baixar tren d’aterratge\n" : "4- Pujar tren d’aterratge\n";
        msg += "5- Modificar alçada\n" +
                "6- Establir rumb\n" +
                "7- Retornar Estat de l’Avió (Llegir estat Avió)\n" +
                "8- Sortir";
        return msg;
    }

    public static final String planeTypeMenu =
            "Chose between two airplane types:\n" + "1-Commercial\n" + "2-Military";

    //Verbose
    public static final String notValidOption = "Not valid option!";
    public static final String planeLicensePlate = "Write license plate: ";
    public static final String commercialPlaneCreated = "Commercial airplane created on the landing track";
    public static final String militaryPlaneCreated = "Military airplane created on the landing track";
    public static final String planeNotCreatedError = "Plane not created due to an error";
    public static final String noPlanesCreated = "You haven't created any airplane yet";
    public static final String listPlanes = "Listing all available airplanes...";
    public static final String chosePlane = "Chose an airplane: ";
}
