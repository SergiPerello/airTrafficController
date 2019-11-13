package com.sergames;

import java.util.Scanner;

public class UserInteraction {
    public static final String airTrafficControllerMenu =
        "1- Afegir un avió a l’espai aeri\n" +
        "2- Gestionar un avió de l’espai Aeri\n" +
        "3- Mostrar L’espai Aeri actual\n" +
        "4- Xifrar els avions de combat\n" +
        "5- Desxifrar els avions de combat\n";
    public static final String airplaneManagementMenu =
        "1- Encendre i apagar motors\n" +
        "2- Accelerar i Frenar\n" +
        "3- Pujar Tren d’aterratge i Baixar tren d’aterratge\n" +
        "4- Modificar alçada\n" +
        "5- Establir rumb\n" +
        "6- Retornar Estat de l’Avió (Llegir estat Avió)\n";

    private String askOptionToUser(String pattern, String textToDisplay, String invalidInput) {
        System.out.println(textToDisplay);
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (!answer.matches(pattern)){
            System.out.println(invalidInput);
            answer = askOptionToUser(pattern,textToDisplay,invalidInput);
        }
        return answer;
    }
}