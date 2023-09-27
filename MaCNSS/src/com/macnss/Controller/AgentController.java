package com.macnss.Controller;

import com.macnss.Controller.Services.EmailService;
import com.macnss.Model.DAOimplementation.AgentDAO;
import com.macnss.Model.Models.DTO.Agent;
import com.macnss.helpers.VerificationHelper;
import java.util.Random;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentController {
    private static Scanner scanner = new Scanner(System.in);
    private  static  AgentDAO agent=new AgentDAO();
    public  static boolean login() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your email");
        String email = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();

        //admin.lgine(email,password).toString();
        if (agent.lgine(email,password)!= null) {
            //send email
            String code = "2121";
            System.out.println("chek your email");
            EmailService.sendEmail(code,"your code",email);
            System.out.println("insert code");
            String codeFromAgent=scanner.nextLine();
            if(codeFromAgent.equals(code) ){
                System.out.println("welcome agent");
                return  true;
            }



        }else {
            System.out.println("try agine ");
        }

        return  false;
    }


    public static void saveAgent() throws SQLException {
        System.out.println("enter the email of agent");
        String email=scanner.nextLine();
        System.out.println("enter the password of agent");
        String password=scanner.nextLine();
        Agent agent=new Agent();
        agent.setEmail(email);
        agent.setPassword(password);
        AgentDAO agentDAO=new AgentDAO();
        if (agentDAO.save(agent)){
            System.out.println("Agent is added");
        }else {
            System.out.println("something was worng");
        }
    }

    public static void deleteAgent() throws SQLException {
        AgentDAO agentDAO=new AgentDAO();
        System.out.println("enter the id of agent");
        int id= VerificationHelper.checkInt();
        if (agentDAO.getOne(id)!=null){
                                if ( agentDAO.delete(id)){
                                    System.out.println("agent deleted");
                                } else System.out.println("smthing was wrong");

        }else{ System.out.println("no Agent with this id: "+id);}
    }
}
