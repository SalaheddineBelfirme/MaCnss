package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.SocietyDAO;
import com.macnss.Model.Models.DTO.Society;
import com.macnss.helpers.VerificationHelper;

import java.security.PrivateKey;
import java.util.Scanner;

public class SocietyController {
    private static Scanner scanner=new Scanner(System.in);
    private static SocietyDAO societyDAO=new SocietyDAO();

    public static   boolean save(){
        System.out.println("Enter Name Of Your Society ");
        String Name =scanner.nextLine();
        System.out.println("Enter Email Of Your Society ");
        String Email =scanner.nextLine();
        System.out.println("Enter Password Of Your Society ");
        String Password =scanner.nextLine();
        Society society=new Society(1,Name,Email,Password);
        if (societyDAO.save(society)){
            System.out.println("Your Society Is Ceated");
            return true;
        }
        else {
            System.out.println("try agin");
        }
return false;
    }
    public  static void  delete(){
        System.out.println("Enter the key of your Society");
        int id_society= VerificationHelper.checkInt();
        System.out.println("Enter the password of your Society");
        String password=scanner.nextLine();
        if (societyDAO.Delete(id_society,password)){
            System.out.println("your Society is deleted");
        }else {
            System.out.println("try agin");
        }

    }
    public static void ubdateNumberDays(){
       PatientController.ubdateNumberDays();
    }
    public static boolean login(){
        System.out.println("enter email of your society ");
        String email=scanner.nextLine();
        System.out.println("enter password of your society");
        String password =scanner.nextLine();
        if (SocietyDAO.lgine(email,password)!=null){
            System.out.println("login don");
            return  true;
        }
        return false;
    }
    public static Society get(){
        System.out.println("enter the id of your Society");
        int id_society=VerificationHelper.checkInt();
        if (societyDAO.get(id_society)!=null){
            return societyDAO.get(id_society);
        }
        System.out.println("no Society with this id  :"+id_society);
        return null;

    }



}
