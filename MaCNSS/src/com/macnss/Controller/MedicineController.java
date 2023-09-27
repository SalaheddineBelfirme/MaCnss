package com.macnss.Controller;

import com.macnss.Model.Database.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MedicineController {
    public static Map<String, Float> get() {
        String query = "SELECT * FROM medicine";
        Map<String, Float> medicentMap = new HashMap();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                medicentMap.put(resultSet.getString("ean_code"), resultSet.getFloat("reimbursable_price"));
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while fetching medicines");
            System.out.println(e.getMessage());
        }
        return medicentMap;
    }
}
