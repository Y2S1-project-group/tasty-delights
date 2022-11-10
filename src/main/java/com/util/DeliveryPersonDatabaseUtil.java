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
            String query = String.format("select * from delivery_person");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String contact = rs.getString("contact");

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
}
