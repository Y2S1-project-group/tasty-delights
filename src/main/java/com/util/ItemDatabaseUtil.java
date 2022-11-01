package com.util;

import com.controller.DatabaseConnection;
import com.model.Item;
import com.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDatabaseUtil{
    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        //create database connection
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = "select * from item";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                int price = rs.getInt(4);
                String image = rs.getString(5);

                Item temp = new Item(id, name, qty, price,image);
                items.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public ArrayList<Item> getAnItem(int itemID) {
        ArrayList<Item> item = new ArrayList<Item>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from item where id = '" + itemID + "'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("qty");
                int  price = rs.getInt("price");
                String image = rs.getString("image");

                Item temp;
                temp = new Item(id, name, quantity,price, image);
                item.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public boolean updateAnItem (int id, String name, int quantity, int price) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("update item " +
                    "set name='" + name + "', " +
                    "price='" + price + "', " +
                    "qty='" + quantity + "'" +
                    "where id='" + id + "'");
            int count = st.executeUpdate(query);
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAnItem(int id) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("delete from item where id='"+ id + "'");
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

