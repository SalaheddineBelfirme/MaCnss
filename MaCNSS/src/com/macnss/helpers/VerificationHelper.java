package com.macnss.helpers;

import java.util.Scanner;

public class VerificationHelper {

    public static   int checkInt(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int num ;
        do {
            if (scanner.hasNextInt()) {
                validInput = true;
                num = scanner.nextInt();
                return num;
            } else {
                System.out.println("Enter a valid number:");
                scanner.nextLine();
            }
        } while (!validInput);

        return 0;
    }







}


