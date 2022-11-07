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
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String des = rs.getString("des");
                String category = rs.getString("category");

                Item temp = new Item(id, name, des, price,category, image);
                items.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public Item getAnItem(int itemID) {
        Item temp = null;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from item where id = '" + itemID + "'");
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String des = rs.getString("des");
                String category = rs.getString("category");

                temp = new Item(id, name, des, price, category, image);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public boolean updateAnItem (int id, String name, String description, String category, double price , String image) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("update item set name = '%s', des = '%s', category = '%s', price = '%f', image = '%s' where id = '%d'", name, description, category, price, image, id);
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
    public boolean createItems(String name, String description, String category, double price, String image) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("insert into item (name, category, des, price, image) values ('" + name + "', '" + category + "','" + description + "', '" + price + "', '" + image + "')");
            int count = st.executeUpdate(query);
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Item> searchItems(String search) {
        ArrayList<Item> items = new ArrayList<Item>();
        //create database connection
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = null;
            if(search != null){
                 query = "select * from item where name like '%" + search + "%'";
            }else{
                 query = "select * from item";
            };
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String des = rs.getString("des");
                String category = rs.getString("category");


                Item temp = new Item(id, name, des, price, category, image);
                items.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

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

