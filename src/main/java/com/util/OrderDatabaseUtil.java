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
}
