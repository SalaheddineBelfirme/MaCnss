package com.macnss.Model.DAOimplementation;

import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Admin;
import com.macnss.Model.Models.DTO.Agent;
import  com.macnss.Model.DAO.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AgentDAO implements DAO<Agent>{

    public Agent lgine(String email , String password) {
        Agent agent=null;
        String query = "select * from agent where email=? and password=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2,password.hashCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                agent=new Agent(resultSet.getInt("agent_id"),resultSet.getString("email"),resultSet.getString("password"));
                return  agent;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("something went wrong ");

            System.out.println(e.getMessage());
        }
        return null;
    }


    public Agent getOne(int id) throws SQLException {
        Agent agent=null;
        String query = "select * from agent where agent_id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {

                 agent=new Agent(resultSet.getInt("agent_id"),resultSet.getString("email"),resultSet.getString("password"));
                return  agent;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("something went wrong while inserting new Agent record");

            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Agent> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(Agent o) throws SQLException {
        String query = "INSERT INTO `agent`(`email`,`password`) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,o.getEmail());
            preparedStatement.setInt(2,o.getPassword().hashCode());

            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while inserting new Agent record");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Agent o) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(int id) throws SQLException {
        String query = "delete from `agent` where agent_id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while deleting old Agent record");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
