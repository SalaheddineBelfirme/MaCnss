package com.macnss.View;

import com.macnss.Controller.AdminController;
import com.macnss.Controller.AgentController;
import com.macnss.Controller.CnssFormController;

import java.sql.SQLException;
import java.util.Scanner;

public class MaCNSS {
    public static Scanner scanner = new Scanner(System.in);
    public static void startProject() {
        int choice = displayDashboards();
        switch (choice) {
            case 1:
                if(loginAsAdmin())
                    displayAdminDashboard();
                break;
            case 2:
                if(loginAsAgent())
                    displayAgentDashboard();
                break;
            case 3:
                displayPatientDashboard();
                break;
            case 4:
                System.out.println("Exiting the program");
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }

    private static int displayDashboards() {
        System.out.println(
                System.getenv("MACNSS_EMAIL")
        );
        System.out.println("1. Display Admin Dashboard");
        System.out.println("2. Display Agent Dashboard");
        System.out.println("3. Display Patient Dashboard");
        System.out.println("4. Exit");

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
                case 4:
                    System.out.println("Exiting the program");
                    System.exit(0);
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
                    System.out.println("Exiting the program");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }
    private static void displayPatientDashboard() {
        System.out.println("You ware a patient and you want to display your history");
    }

    private static int adminMenu() {
        System.out.println("Welcome Mr Admin");
        System.out.println("1. Create new agent account");
        System.out.println("2. Delete old agent account");
        System.out.println("4. Exit");
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
        System.out.println("4. Exit");
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return agentMenu();
        }
        return Integer.parseInt(choice);
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
