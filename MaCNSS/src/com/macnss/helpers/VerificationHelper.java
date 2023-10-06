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



    public static   int checkFlout(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int num ;
        do {
            if (scanner.hasNextFloat()) {
                validInput = true;
                num = scanner.nextInt();
                return num;
            } else {
                System.out.println("Enter a valid flout number:");
                scanner.nextLine();
            }
        } while (!validInput);

        return 0;
    }

    public class RetirementSalary {
        public static float calcEmployeeRetirementSalary(int workDays, float baseSalary) {
            float retirementSalary = 0;
            // First case:
            if(isInNoIncresementRange(workDays)) {
                baseSalary = (float) (baseSalary * 0.5);
            } else {
                // Second case:
                float baseRetirementSalary = (float) (baseSalary * 0.5);
                float baseSalaryIncresementPercentage = (workDays - 3240) / 216;
                if(baseSalaryIncresementPercentage > 20)
                    baseSalaryIncresementPercentage = 20;
                retirementSalary = (float) (baseRetirementSalary * ((baseRetirementSalary * 0.01) * baseSalaryIncresementPercentage));
            }
            return retirementSalaryAcceptableRange(retirementSalary);
        }

        private static boolean isInNoIncresementRange(int workDays) {
            if(workDays > 1230 && workDays < 3240) {
                return true;
            }
            return false;
        }

        private static float retirementSalaryAcceptableRange(float retirementSalary) {
            if(retirementSalary > 6000)
                return 6000;
            else if(retirementSalary < 1000)
                return 1000;
            return retirementSalary;
        }
    }


}


