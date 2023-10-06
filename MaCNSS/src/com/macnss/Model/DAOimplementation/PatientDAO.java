package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Patient;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

public class PatientDAO implements DAO<Patient> {
    @Override
    public List<Patient> getAll() throws SQLException {
        return null;
    }
    @Override
    public Boolean save(Patient o) {
        try {
            Connection connection=DBConnection.getConnection();
            String Requst="INSERT INTO `patient`(`full_name`, `cin`, `address`, `birth_date`, `number_days`, `stil_work`, `is_benefit`, `society_id`, `salery`) VALUES (?,?,?,?,0,1,0,?,?)";
            try {
                PreparedStatement stm=connection.prepareStatement(Requst);
                stm.setString(1,o.getFullName());
                stm.setString(2,o.getCin());
                stm.setString(3,o.getAddress());
                stm.setString(4, String.valueOf(o.getBirthDate()));
                stm.setInt(5,o.getSociety_id());
                stm.setFloat(6,o.getSalery());
                int res=stm.executeUpdate();
                if (res>0){
                    return  true;
                }
            }catch (Exception e){
                System.out.println("samting when save Patient ");
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("samting in connction ");
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Boolean update(Patient o) throws SQLException {
        return null;
    }
    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }
    public static Patient get(int registrationNumber) {
        String query = "SELECT * FROM patient WHERE registration_number = ?";
        Patient patient = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, registrationNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                patient = new Patient();
                patient.setRegistrationNumber(resultSet.getInt("registration_number"));
                patient.setFullName(resultSet.getString("full_name"));
                patient.setCin(resultSet.getString("cin"));
                patient.setAddress(resultSet.getString("address"));
                patient.setBirthDate(resultSet.getDate("birth_date"));
                patient.setNumber_days(resultSet.getInt("number_days"));
                patient.setSalery(resultSet.getFloat("salery"));
                patient.setSociety_id(resultSet.getInt("society_id"));
                patient.setIs_benefit(resultSet.getBoolean("is_benefit"));
                patient.setStil_work(resultSet.getBoolean("stil_work"));


            }
        } catch (SQLException e) {
            System.out.println("something went wrong while fetching patient record");
            System.out.println(e.getMessage());
        }
        return patient;
    }
    public static   boolean  addDays(int numberdays,int registrationNumber){
        try {
            System.out.println(registrationNumber);
            Connection connection=DBConnection.getConnection();
            String Requst="Update patient set number_days=number_days+? where registration_number=?";
            PreparedStatement preparedStatement=connection.prepareStatement(Requst);
            preparedStatement.setInt(1,numberdays);
            preparedStatement.setInt(2,registrationNumber);
            try {
              int res =  preparedStatement.executeUpdate();
              if (res>0){
                  return  true;
              }

            }catch (Exception e){
                System.out.println("samting when You add days");
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("samting worng when get Connction");
            System.out.println(e.getMessage());

        }
        return false;
    }
    public static Patient getFromOutWork(int registrationNumber) {
        String query = "SELECT * FROM patient WHERE registration_number = ? and society_id=0";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, registrationNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Patient  patient = new Patient();
                patient.setRegistrationNumber(resultSet.getInt("registration_number"));
                patient.setFullName(resultSet.getString("full_name"));
                patient.setCin(resultSet.getString("cin"));
                patient.setAddress(resultSet.getString("address"));
                return patient;
            }
            else {
                System.out.println("no employee free with the id "+registrationNumber);
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while fetching patient record");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static   boolean  setToNewScociety(int registrationNumber ,float salery,int society_id){
        try {
            Connection connection=DBConnection.getConnection();
            String Requst="UPDATE `patient` SET `stil_work`=1,`society_id`=? ,`salery`=? WHERE patient.registration_number=?";
            PreparedStatement preparedStatement=connection.prepareStatement(Requst);
            preparedStatement.setInt(1,society_id);
            preparedStatement.setFloat(2,salery);
            preparedStatement.setInt(3,registrationNumber);
            try {
                int res =  preparedStatement.executeUpdate();
                if (res>0){
                    return  true;
                }

            }catch (Exception e){
                System.out.println("samting when You set employee to new society");
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("samting worng when get Connction");
            System.out.println(e.getMessage());

        }
        return false;
    }
    public static boolean deleteFromSociety(int registrationNumber ){
        try {

            Connection connection=DBConnection.getConnection();
            String Requst="UPDATE `patient` SET `stil_work`=0,`society_id`=0 WHERE registration_number=?";
            PreparedStatement preparedStatement=connection.prepareStatement(Requst);
            preparedStatement.setInt(1,registrationNumber);
            try {
                int res =  preparedStatement.executeUpdate();
                if (res>0){
                    return  true;
                }

            }catch (Exception e){
                System.out.println("samting when You delte employee days");
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("samting worng when get Connction");
            System.out.println(e.getMessage());

        }
        return false;
    }
    public static Map<String, Object>getMoyenSalery(int registrationNumber) {
        Map<String,Object>saleryWithRows=new HashMap<>();
        String query = "SELECT SUM(salery_month)AS total_salary, COUNT(*) as numberMonths  FROM `patient_salery` WHERE patient_salery.id_patient=? ORDER by date DESC  LIMIT 96";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, registrationNumber);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                float salary =resultSet.getFloat("total_salary");
                int numberMnths =resultSet.getInt("numberMonths");
                saleryWithRows.put("salery",salary);
                saleryWithRows.put("numberMonths",numberMnths);
                return saleryWithRows;
            }

        } catch (SQLException e) {
            System.out.println("something went wrong while fetching patient salery");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static int getNumberDays(int registrationNumber) {
        String query = "SELECT number_days FROM `patient` WHERE patient.registration_number=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, registrationNumber);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                int NumberDays =resultSet.getInt("number_days");
                return  NumberDays;
            }

        } catch (SQLException e) {
            System.out.println("something went wrong while fetching patient salery");
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public static boolean setbenfit(int registrationNumber,float salery) {
        String query = "update `patient` set stil_work=1 and salery = ? WHERE patient.registration_number=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setFloat(1,salery);
            preparedStatement.setInt(2, registrationNumber);
            int res =  preparedStatement.executeUpdate();
            if(res>0){
                return  true;
            }

        } catch (SQLException e) {
            System.out.println("something waz wrong while set the employee benefit");
            System.out.println(e.getMessage());
        }
        return false;
    }


}
