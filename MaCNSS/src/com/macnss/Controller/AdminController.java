package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.AdminDAO;
import com.macnss.Model.Models.DTO.Admin;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminController {

   private static AdminDAO admin=new AdminDAO();

    public  static boolean login() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your email");
        String email = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();

        //admin.lgine(email,password).toString();
        if (admin.lgine(email,password)!= null) {
            //send email
            System.out.println("welcome mr mr");
            return  true;

        }else {
            System.out.println("try agine ");
        }

        return  false;
    }

}
