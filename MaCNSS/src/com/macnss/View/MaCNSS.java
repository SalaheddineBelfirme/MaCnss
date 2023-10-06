package com.macnss.View;

import com.macnss.Controller.*;
import com.macnss.helpers.VerificationHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class MaCNSS {
    public static Scanner scanner = new Scanner(System.in);
    public static void startProject() {
        int choice = displayDashboards();
        switch (choice) {
            case 1:
                if(loginAsAdmin()){
                    displayAdminDashboard();
                }
                else {startProject();}

                break;

            case 2:
                if(loginAsAgent()){
                    displayAgentDashboard();}
                else {startProject();}
                break;
            case 3:
                displayPatientDashboard();
                break;
            case 4:
                    displaySocietyDas();

                break;

            case 0:
                System.out.println("Exiting the program");
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }

    private static int displayDashboards() {
        System.out.println("1. Display Admin Dashboard");
        System.out.println("2. Display Agent Dashboard");
        System.out.println("3. Display Patient Dashboard");
        System.out.println("4. Display society Dashboard");
        System.out.println("0. Exsit");
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return displayDashboards();
        }
        return Integer.parseInt(choice);
    }

    private static void displayAdminDashboard()  {
        while (true) {
            switch (adminMenu()) {
                case 1:
                    System.out.println("You want to create a agent account");
                 try {
                     AgentController.saveAgent();
                 }catch (Exception e){
                     new RuntimeException();
                 }
                    break;
                case 2:
                    System.out.println("You want to delete a agent account");
                    try {
                        AgentController.deleteAgent();
                    }catch (Exception e){
                        new RuntimeException();
                    }
                    break;
                case 0:
                    startProject();
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }
    private static void displayAgentDashboard() {
        while (true) {
            switch (agentMenu()) {
                case 1:
                    System.out.println("You want to create a Reimbursement folder");
                    CnssFormController.saveCnssForm();
                    break;
                case 2:
                    System.out.println("You want to update a Reimbursement folder status");
                    CnssFormController.updateCnssFormStatus();
                    break;
                case 0:
                    startProject();
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }
    private static void displayPatientDashboard() {
        while (true) {
            switch (PatientMenu()) {
                case 1:

                    PatientController.getHestoriy();
                    startProject();
                    break;
                case 2:
                    System.out.println("You want to check if ritared");
                    PatientController.checkifbenefit();
                    startProject();
                    break;
                case 0:
                    startProject();
                default:
                    System.out.println("Please enter a valid option");
            }
        }






    }
    private static void displaySocietyDas() {
        while (true) {
            switch (SocietyMenu()) {
                case 1:
                    System.out.println("You want to create a Society");
                    if(SocietyController.save()){
                    displaySocietyDashboard();
                    }else {
                        System.out.println("try agine");
                        displaySocietyDas();
                    }
                    break;
                case 2:
                    System.out.println("You want to login a Society");
                    if (SocietyController.login()){
                        displaySocietyDashboard();
                    }
                    else {
                        System.out.println("try agin");
                        displaySocietyDas();
                    }
                    break;
                case 0:
                    startProject();
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }
    private static void displaySocietyDashboard() {
        while (true) {
            switch (SocietyMenuPr()) {

                case 1: {
                    System.out.println("You want to create a empoly");
                    System.out.println("the Empoly have account in the cnss");
                    System.out.println("1 YES");
                    System.out.println("2 NO");
                    int choice = VerificationHelper.checkInt();
                    if (choice == 1) {
                        PatientController.setTonewSociety();
                    } else if (choice == 2) {
                        PatientController.save();
                    } else {
                        System.out.println("enter valid value ");
                    }
                }
                    break;
                case 2:
                    System.out.println("You want to remove a empoly");
                    PatientController.deleteFRomSociety();
                    break;
                case 3:
                    System.out.println("You want to Remove Your Society");
                    SocietyController.delete();
                    displaySocietyDas();
                    break;
                case 4:
                    System.out.println("You want to add days to Your Employee");
                    SocietyController.ubdateNumberDays();
                    displaySocietyDashboard();
                    break;
                case 5:
                    PatientController.set_benefit();
                    displaySocietyDashboard();
                    break;
                case 0:
                    startProject();
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }


    private static int adminMenu() {
        System.out.println("Welcome Mr Admin");
        System.out.println("1. Create new agent account");
        System.out.println("2. Delete old agent account");
        System.out.println("0. back to home");
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return agentMenu();
        }
        return Integer.parseInt(choice);
    }
    private static int agentMenu() {
        System.out.println("You want to display agent dashboard");
        System.out.println("1. Create new Reimbursement folder");
        System.out.println("2. Update Reimbursement folder status");
        System.out.println("3. Delete Reimbursement folder");
        System.out.println("0. back to home");
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return agentMenu();
        }
        return Integer.parseInt(choice);
    }
    private static int  SocietyMenu() {
        System.out.println("1. Create new Society ");
        System.out.println("2. login  to your Society ");
        System.out.println("0. back to home");
        int choice =VerificationHelper.checkInt();
        return choice;
    }
    private static int  SocietyMenuPr() {
        System.out.println("welcom in societe dashboard");
        System.out.println("1. Create new empley ");
        System.out.println("2. remove empley ");
        System.out.println("3 Remove Your Society");
        System.out.println("4 Add Days of  Your Employee");
        System.out.println("5 set Your Employee benefit");
        System.out.println("0. back to home");
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return agentMenu();
        }
        return Integer.parseInt(choice);
    }
    private static int  PatientMenu() {
        System.out.println("1. get hestoriq ");
        System.out.println("2. chek ritared salary ");
        System.out.println("0. back to home");
        int choice =VerificationHelper.checkInt();
        return choice;
    }


    private static boolean loginAsAdmin() {

        try {
            if (  AdminController.login()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return     false;
    }
    private static boolean loginAsAgent() {
        try {
            if (  AgentController.login()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return     false;
    }

    private static boolean isInteger(String string) {
        boolean res = false;
        try {
            Integer.parseInt(string);
            res = true;
        } catch (NumberFormatException e) {
            res = false;
        }
        return res;
    }
}
