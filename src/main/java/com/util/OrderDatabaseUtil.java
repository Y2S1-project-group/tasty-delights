package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.OrderDatabase;
import com.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDatabaseUtil implements OrderDatabase {
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                orders.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<Order> getPendingOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'pending'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                orders.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<Order> getPreparingOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'preparing'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                orders.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<Order> getDeliveringOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'delivering'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                orders.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<Order> getCompletedOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where status = 'completed'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                orders.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<Order> getAnOrder(int orderID) {
        ArrayList<Order> order = new ArrayList<Order>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from orders where id = '" + orderID + "'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int cusid = rs.getInt("cusid");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                double tprice = rs.getDouble("price");
                String orderedtime = rs.getString("orderedtime");

                Order temp;
                temp = new Order(id, cusid, name, quantity, status, tprice, orderedtime);
                order.add(temp);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public boolean updateAnOrder(int id, String name, int quantity, double price) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("update orders " +
                    "set name='" + name + "', " +
                    "price='" + price + "', " +
                    "quantity='" + quantity + "'" +
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

    public boolean deleteAnOrder(int id) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("delete from orders where id='"+ id + "'");
            int count = st.executeUpdate(query);
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOrderStatus(int id, String status) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("update orders set status='" + status + "' where id='" + id + "'");
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
