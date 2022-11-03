package com.util;
import com.controller.DatabaseConnection;
import com.model.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDatabaseUtil {


    public ArrayList<Item> getHomeItems()  {
        ArrayList<Item> homePageItems = new ArrayList<Item>();
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            String query =  String.format("SELECT * FROM item");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("des");
                float price = rs.getFloat("price");
                String category = rs.getString("category");
                String image = rs.getString("image");
                Item temp = new Item(id , name , des , price, category ,image);
                homePageItems.add(temp);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return homePageItems;
    }
}
