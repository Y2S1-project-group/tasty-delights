package com.util;

import com.controller.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class ContactUsDatabaseUtil {

    public int addContactUsForm(String name ,String phone,  String email, String message){
        String query = String.format("INSERT INTO contact (name, email , phone , messages)VALUES ( '%s', '%s' , '%s' ,'%s');",name ,email ,phone, message );
        int res = 0;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            res = st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
