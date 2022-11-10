package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.DeliveryPersonDatabase;
import com.model.DeliveryPerson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DeliveryPersonDatabaseUtil implements DeliveryPersonDatabase {

    public boolean checkLogin(String email, String password) {
        try{
            PasswordUtil passwordUtil = new PasswordUtil();
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from delivery_person where email = '%s' and password = '%s'", email, password);
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
    public ArrayList<DeliveryPerson> getDeliveryPersons() {
        ArrayList<DeliveryPerson> deliveryPersons = new ArrayList<DeliveryPerson>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = "select * from delivery_person";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String username = rs.getString("user_name");
                String password = rs.getString("password");

                DeliveryPerson temp;
                temp = new DeliveryPerson(id, name, age, contact, email);
                deliveryPersons.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliveryPersons;
    }

    public boolean addDeliveryPerson(String name , int age, String contact , String email ,String username,  String password ) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("insert into delivery_person (name, age, email, contact, user_name , password) values ('%s' , %d , '%s' ,'%s', '%s', '%s' )", name , age ,  email ,contact, username,  password );
            int count = st.executeUpdate(query);
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteADelivery(int id) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("delete from delivery_person where id = %d", id);
            int count = st.executeUpdate(query);
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
