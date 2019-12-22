package com.sergames;

import java.util.Scanner;

public class askUser {
    public static String askUser(String textToDisplay) {
        System.out.println(textToDisplay);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String askUser(String pattern, String textToDisplay, String invalidInput) {
        System.out.println(textToDisplay);
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (!answer.matches(pattern)) {
            System.out.println(invalidInput);
            answer = askUser(pattern, textToDisplay, invalidInput);
        }
        return answer;
    }
}
