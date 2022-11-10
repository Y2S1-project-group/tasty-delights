package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.DeliveryOrder;
import com.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DeliveryOrderDatabaseUtil implements DeliveryOrder {

    @Override
    public boolean addOrderToDelivery(int did, int orderId) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            PreparedStatement st = conn.prepareStatement("insert into delivery_order(did, order_id, status) values(?, ?, ?);");
            st.setInt(1, did);
            st.setInt(2, orderId);
            st.setString(3, "delivering");
            int count = st.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList <DeliveryOrder> getDeliveryOrders(){
        ArrayList<DeliveryOrder> deliveryOrders = new ArrayList<DeliveryOrder>();
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from delivery_orders where status = 'delivering'");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                int orderId = rs.getInt("order_id");
                int deliveryPersonId = rs.getInt("did");
                String status = rs.getString("status");
                DeliveryOrder order = new DeliveryOrder(orderId, deliveryOrders, status);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliveryOrders;
    }
}
