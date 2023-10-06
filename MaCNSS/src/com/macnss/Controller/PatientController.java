package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.CnssFormDAO;
import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.DAOimplementation.SocietyDAO;
import com.macnss.Model.Models.DTO.CnssForm;
import com.macnss.Model.Models.DTO.Patient;
import com.macnss.Model.Models.DTO.Society;
import com.macnss.helpers.VerificationHelper;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class PatientController {
    private static Scanner scanner=new Scanner(System.in);
    private  static PatientDAO patientDAO;

    public static void getHestoriy(){
        System.out.println("Enter your Number :");

        int numberPatetint= VerificationHelper.checkInt();
        CnssFormDAO cnssForm=new CnssFormDAO();
        System.out.println("your hestoriq here ");
        System.out.println(cnssForm.getHestoriy(numberPatetint));
    }
    public static void ubdateNumberDays(){
        System.out.println("enter the registration number");
        int registration_number=VerificationHelper.checkInt();
        if (PatientDAO.get(registration_number)!=null){
            System.out.println("1 for add days ");
            System.out.println("2 for delete days ");
            int choice =VerificationHelper.checkInt();
            if (choice==1){
                System.out.println("enter the number of days");
                int number_days=VerificationHelper.checkInt();
                if (PatientDAO.addDays(number_days,registration_number)){
                    System.out.println("number days is updated");

                }else {
                    System.out.println("try agin");
                }
            }
            else if (choice==2) {
                System.out.println("enter the number of days");
                int number_days=VerificationHelper.checkInt();
                if (PatientDAO.addDays(-number_days,registration_number)){
                    System.out.println("number days is updated");

                }else {
                    System.out.println("try agin");
                }

            }
            else {
                System.out.println("enter a valid number");
            }

        }else {
            System.out.println("no emply with this registration number ");
        }

    }
    public  static  void setTonewSociety(){
        System.out.println("enter the id of employee");
        int id_employee=VerificationHelper.checkInt();

        if(PatientDAO.getFromOutWork(id_employee)!=null){
                System.out.println("enter the salery of your employee");
                int salery=VerificationHelper.checkFlout();
                Society society=SocietyController.get();
                if (society!=null){
                    if (society.getSociety_id()!=0){
                       if ( PatientDAO.setToNewScociety(id_employee,salery,society.getSociety_id())){
                           System.out.println("you put new employee");
                       }else {
                           System.out.println("try agin");
                       }

                    }
                    else {
                        System.out.println("enter valid id of society");
                    }

                }




        }
    }
    public static  void deleteFRomSociety(){
        System.out.println( "enter id of employee");
        int employee_id=VerificationHelper.checkInt();
    if( PatientDAO.deleteFromSociety(employee_id)){
        System.out.println("the employee en hold now");
    }   else {
        System.out.println("try agin ");
    }


    }
    public  static  void  save(){
        System.out.println("wlecome to add new employee");
        Society society=SocietyController.get();
        if (society!=null){
            System.out.println("Enter the full name of employee");
            String name=scanner.nextLine();
            System.out.println("Enter the CIN of employee");
            String CIN=scanner.nextLine();
            System.out.println("Enter the birthdate of employee");
            String birthdate=scanner.nextLine();
            System.out.println("Enter the adderss of employee");
            String adderss=scanner.nextLine();
            System.out.println("Enter the salery of employee");
            float salery=VerificationHelper.checkFlout();
            Patient patient=new Patient(1,name,CIN,society.getSociety_id(),0,salery,true,false,adderss, Date.valueOf(birthdate) );
            patientDAO=new PatientDAO();
            if (patientDAO.save(patient)){
                System.out.println("your employee is added ");
            }else {
                System.out.println( "try agin ");
            }

        }



    }
    public static void  set_benefit (){
        System.out.println("enter the id of employee");
        int id =VerificationHelper.checkInt();
        int numberDays=PatientDAO.getNumberDays(id);
        float AvarageSalary=0;
        float perecentage=0;
        if(numberDays>=1320 ){
            if (numberDays>=3240){
                if(PatientDAO.getMoyenSalery(id)!=null){
                //  MoyanSalery=(Float)PatientDAO.getMoyenSalery(id).get("salery")/(int)PatientDAO.getMoyenSalery(id).get("numberMonths");
                    AvarageSalary=((Float)PatientDAO.getMoyenSalery(id).get("salery")/96);
                }
                 perecentage=((numberDays-3240)/216);
                if (perecentage>20){
                    perecentage=20;
                }

            }else{
                AvarageSalary=(Float)PatientDAO.getMoyenSalery(id).get("salery")/(int)PatientDAO.getMoyenSalery(id).get("numberMonths");
                perecentage=0;
            }
            float retired_salary= AvarageSalary*((50+perecentage)/100f);
            if (retired_salary>6000){
                retired_salary=6000;
            } else if (retired_salary<1000) {
                retired_salary=1000;
            }
            Patient patient =PatientDAO.get(id);
             Date date =(Date)patient.getBirthDate();
            Calendar calNow = Calendar.getInstance();
            Calendar clabirthday = Calendar.getInstance();
           clabirthday.setTime(date);
            int age =calNow.get(Calendar.YEAR)-clabirthday.get(Calendar.YEAR);
            if (age>=55){
                if (PatientDAO.setbenfit(id,retired_salary)){
                    System.out.println("Hi MR "+patient.getFullName()+" Your Retired Salary  is  :"+retired_salary);
                }else {
                    System.out.println("Hi MR "+patient.getFullName()+"Can You try again");
                }
            }
            else {
                System.out.println("Hi MR"+patient.getFullName()+" Your retired Salary  is  :"+retired_salary +"you will receive it  After"+(55-age));
            }
        }
        else {
            System.out.println("you need 1320 days to take your retired salary and the number of your working days is :"+numberDays);
        }

    }
    public static void checkifbenefit(){
        System.out.println("enter the id of employee");
        int id =VerificationHelper.checkInt();
        Patient patient=PatientDAO.get(id);
        if (patient.isIs_benefit()){
            System.out.println("Hi MR "+patient.getFullName()+" Your Retired Salary  is  :"+patient.getSalery());

        }
        else {
            System.out.println("Hi MR "+patient.getFullName()+" your are not Retired you can ask your Society " ) ; }
    }

}