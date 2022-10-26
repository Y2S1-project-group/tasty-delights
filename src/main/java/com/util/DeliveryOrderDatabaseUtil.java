package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.DeliveryOrder;

import java.sql.Connection;
import java.sql.Statement;

public class DeliveryOrderDatabaseUtil implements DeliveryOrder {

    public void addOrderToDelivery(int orderId) {
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("insert into delivery_order('order_id', 'status') values("+ orderId + ", 'delivering');");
            int count = st.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
