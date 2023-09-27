package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Patient;

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
    public Boolean save(Patient o) throws SQLException {
        return null;
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
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while fetching patient record");
            System.out.println(e.getMessage());
        }
        return patient;
    }
}
