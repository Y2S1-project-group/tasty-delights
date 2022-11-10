package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.CustomerDatabase;
import com.model.Customer;

import java.sql.*;
import java.util.ArrayList;

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
    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from customer");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String address = rs.getString("address");

                Customer temp;
                temp = new Customer(id, fname, lname, email, contact, address);
                customers.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }
    public boolean changePassword(String email, String password){
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            PasswordUtil passwordUtil = new PasswordUtil();

            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            String hashPassword = passwordUtil.encryptString(password);
            PreparedStatement stmt = conn.prepareStatement("UPDATE customer SET password = ? WHERE email= ?;");
            stmt.setString(1, hashPassword);
            stmt.setString(2, email);
            int count = stmt.executeUpdate();

            if(count == 1){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Customer getCustomer(String cid) {
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from customer where id = " + cid + ";");
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String fname = null;
            String lname = null;
            String email = null;
            String contact = null;
            String address = null;
            int age = 0;
            while (rs.next()) {
                id = rs.getInt("id");
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                email = rs.getString("email");
                contact = rs.getString("contact");
                address = rs.getString("address");
                age = rs.getInt("age");
            }

            Customer customer = new Customer(id, fname, lname, email, contact, address, age);
            rs.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCustomer(String cid, String firstName, String lastName, String age, String email, String contact, String address){
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();

            String sql = "update customer set fname = '%s', lname = '%s', age = '%s', email = '%s', contact = '%s', address = '%s' where id = '%s';";
            Statement st = conn.createStatement();
            String query = String.format(sql, firstName, lastName, age, email, contact, address, cid);
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
