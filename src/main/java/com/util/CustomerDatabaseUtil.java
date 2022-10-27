package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.UserDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDatabaseUtil implements UserDatabase {

    public boolean checkLogin(String email, String password) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from User where email = '%s' and password = '%s'", email, password);
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
