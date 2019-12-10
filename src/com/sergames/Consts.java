package com.sergames;

public class Consts {
    //GameConfigurations
    public static final Coordinates landingTrack = new Coordinates(100,100,0);
    public static final int gridSize = 1000;

    //Regular Expressions
    public static final String getAirTrafficControllerMenuOptions = "[1-5]";
    public static final String airplaneManagementMenuOptions = "[1-6]";

    //Menus
    public static final String airTrafficControllerMenu =
            "1- Afegir un avió a l’espai aeri\n" +
                    "2- Gestionar un avió de l’espai Aeri\n" +
                    "3- Mostrar L’espai Aeri actual\n" +
                    "4- Xifrar els avions de combat\n" +
                    "5- Desxifrar els avions de combat";
    public static final String airplaneManagementMenu =
            "1- Encendre i apagar motors\n" +
                    "2- Accelerar i Frenar\n" +
                    "3- Pujar Tren d’aterratge i Baixar tren d’aterratge\n" +
                    "4- Modificar alçada\n" +
                    "5- Establir rumb\n" +
                    "6- Retornar Estat de l’Avió (Llegir estat Avió)";

    public static final String airplaneTypeMenu =
            "Chose between two plane types:\n"+
                    "1-Commercial\n" +
                    "2-Military";
    public static final String notValidOption = "Not valid option!";


}
