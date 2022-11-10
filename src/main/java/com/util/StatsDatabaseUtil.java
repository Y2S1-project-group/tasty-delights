package com.util;

import com.controller.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatsDatabaseUtil {
    // total customers
    public int totalCustomers(){
        int total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from customer");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += 1;
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    // total listed items
    public int totalListedItems(){
        int total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from item");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += 1;
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    // total of completed order
    public double totalSales(){
        double total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from cart_item");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += rs.getDouble("price");
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    // pending order count
    public int pendingOrdersCount(){
        int total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'pending'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += 1;
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    // preparing order count
    public int preparingOrderCount(){
        int total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'preparing'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += 1;
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    // delivering order count
    public int deliveringOrderCount(){
        int total = 0;
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'delivering'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                total += 1;
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    public String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String res = formatter.format(date);
        return res;
    }
}
