package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.CustomerDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDatabaseUtil implements CustomerDatabase {
    public boolean checkLogin(String email, String password) {
        try{
            PasswordUtil passwordUtil = new PasswordUtil();
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from Customer where email = '%s' and password = '%s'", email, passwordUtil.encryptString(password));
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
    public boolean createCustomer(String fname, String lname, String age, String email, String contact, String address, String password){
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into customer(fname, lname, age, email, contact, address, password) values(?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, age);
            st.setString(4, email);
            st.setString(5, contact);
            st.setString(6, address);
            st.setString(7, password);
            int count = st.executeUpdate();
            st.close();
            conn.close();

            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public String getCustomerFirstName(String email) {
        String firstname = null;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select fname from Customer where email = '%s'", email);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            firstname = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstname;
    }
    public String getCustomerLastName(String email) {
        String lastname = null;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select lname from Customer where email = '%s'", email);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            lastname = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastname;
    }
    public String getCustomerID(String email) {
        String cid = null;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select id from Customer where email = '%s'", email);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            cid = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cid;
    }
}
