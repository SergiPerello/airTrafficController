package com.sergames;

import java.util.Scanner;

import static com.sergames.Consts.*;

public class Controller{
    public Controller() {
        airTrafficControllerMenuDecider(Integer.parseInt(
                askOptionToUser(getAirTrafficControllerMenuOptions, airTrafficControllerMenu, notValidOption)));

    }

    private void airTrafficControllerMenuDecider(int option){
        switch (option) {
            case 1:
                //askOptionToUser();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public static String askOptionToUser(String pattern, String textToDisplay, String invalidInput) {
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
