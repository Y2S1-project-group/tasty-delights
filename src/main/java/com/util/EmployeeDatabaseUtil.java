package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.EmployeeDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDatabaseUtil implements EmployeeDatabase {
    public boolean checkLogin(String username, String password) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from Admin where username = '%s' and password = '%s'", username, password);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int count = rs.getRow();
            rs.close();

            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
