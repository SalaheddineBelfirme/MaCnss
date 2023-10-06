package com.macnss.Model.DAOimplementation;

import com.macnss.Controller.PatientController;
import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Agent;
import com.macnss.Model.Models.DTO.Society;
import com.sun.net.httpserver.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class SocietyDAO implements DAO<Society> {
    @Override
    public  List<Society> getAll()  {
        List<Society> societyList=new ArrayList<>() ;
        try {Connection connection= DBConnection.getConnection();
            String request="Select * From Society";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(request);
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Society society=new Society(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                    societyList.add(society);
                }
            }catch (Exception e){
                System.out.println("samting worng when get the Socity");
            }
        }
        catch (Exception e){
            System.out.println("samting worng in connction");
        }
        return societyList;
    }

    @Override
    public Boolean save(Society o){
        try {Connection connection= DBConnection.getConnection();
            String request="INSERT INTO `society`(`society_name`, `society_email`, `society_password`)  values(?,?,?) ";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(request);
                preparedStatement.setString(1,o.getSociety_name());
                preparedStatement.setString(2,o.getSociety_email());
                preparedStatement.setInt(3,o.getSociety_paasword().hashCode());
                int res=preparedStatement.executeUpdate();
                if (res>0){
                    return true;
                }
            }catch (Exception e){
                System.out.println("samting worng when get the Socity");
            }
        }
        catch (Exception e){
            System.out.println("samting worng in connction");
        }
        return false;
    }

    @Override
    public Boolean update(Society o) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }
    public Boolean Delete(int id ,String password)  {
        try {
            Connection connection=DBConnection.getConnection();
            String Requst= "delete from Society where society_id=? and society_password=?";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(Requst);
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,password);
                if (preparedStatement.executeUpdate()>0){
                    return  true;
                }
            }catch (Exception e){
                System.out.println("smating worng when delete the Society");
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("smating worng when get Connction");
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static Society lgine(String email , String password)  {
        Society society=null;
        String query = "select * from society where society_email=? and society_password=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2,password.hashCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                society=new Society(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                return  society;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("something went wrong when login society ");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Society get(int id ){

        try {Connection connection= DBConnection.getConnection();
            String request="Select * From Society where society_id=? and Society_id >0";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(request);
                preparedStatement.setInt(1,id);
                ResultSet resultSet=preparedStatement.executeQuery();
                if (resultSet.next()){
                    Society society=new Society(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                    return  society;
                }
                else {
                    System.out.println("not society with this  id :"+id);
                }
            }catch (Exception e){
                System.out.println("samting worng when get the Socity");
            }
        }
        catch (Exception e){
            System.out.println("samting worng in connction");
        }
        return null;

    }

}
