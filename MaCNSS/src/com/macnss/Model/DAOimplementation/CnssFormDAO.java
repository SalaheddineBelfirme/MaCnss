package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.CnssForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import  java.util.ArrayList;

public class CnssFormDAO implements DAO<CnssForm> {
    public CnssForm get(int id) {
        String query = "SELECT * FROM cnss_form, patient WHERE cnss_form_id = ?";
        CnssForm form = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                form = new CnssForm();
                form.setId(resultSet.getInt("cnss_form_id"));
                form.setPatientNumber(resultSet.getInt("patient_number"));
                form.setTotalPrice(resultSet.getFloat("total_price"));
                form.setStatus(resultSet.getString("status"));
                form.setAttachmentsNumber(resultSet.getInt("cnss_form_id"));
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while fetching refund file record");
            System.out.println(e.getMessage());
        }
        return form;
    }
    @Override
    public List<CnssForm> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(CnssForm form) {
        String query = "INSERT INTO cnss_form (total_price, attachements_number, patient_number) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setFloat(1, form.getTotalPrice());
            preparedStatement.setInt(2, form.getAttachmentsNumber());
            preparedStatement.setInt(3, form.getPatientNumber());
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while inserting new cnss form record");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(CnssForm form) {
        System.out.println("update method called");
        System.out.println(form.toString());
        String query = "UPDATE cnss_form SET total_price = ?, attachements_number = ?, status = ?, patient_number = ? WHERE cnss_form_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setFloat(1, form.getTotalPrice());
            preparedStatement.setInt(2, form.getAttachmentsNumber());
            preparedStatement.setString(3, form.getStatus());
            preparedStatement.setInt(4, form.getPatientNumber());
            preparedStatement.setInt(5, form.getId());
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong while updating refund file record");
            System.out.println(e.getMessage());
        }
        return false;
    }
    public List<CnssForm> getHestoriy(int id){

        try {
            Connection connection=DBConnection.getConnection();
            String Reqest="select * from cnss_form where patient_number=? ";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(Reqest);
                preparedStatement.setInt(1,id);
                ResultSet resultSet=preparedStatement.executeQuery();
                List<CnssForm> lsitFils=new ArrayList<CnssForm>();
                while (resultSet.next()){
                  CnssForm cnssForm=new CnssForm(resultSet.getInt("cnss_form_id"),resultSet.getInt("total_price"),resultSet.getInt("attachements_number"),resultSet.getString("status"),resultSet.getInt("patient_number"));
                    lsitFils.add(cnssForm);
                }
                return lsitFils;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("samtng was worng when get flis of patient");
            }
        }catch (Exception e){
            System.out.println("smting was worng in connction");
            System.out.println(e.getMessage());

        }
        return null ;
    }


    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }
}
