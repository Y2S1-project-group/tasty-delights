package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.EmployeeDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDatabaseUtil implements EmployeeDatabase {
    public boolean checkLogin(String username, String password) {
        try{
            PasswordUtil passwordUtil = new PasswordUtil();
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from Admin where username = '%s' and password = '%s'", username, passwordUtil.encryptString(password));
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
    public boolean updatePassword(String password){
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            PasswordUtil passwordUtil = new PasswordUtil();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String hashPassword = passwordUtil.encryptString(password);
            String query = String.format("update Admin set password='%s' where username = 'Admin'", hashPassword);
            int status = st.executeUpdate(query);
            if(status == 1){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
