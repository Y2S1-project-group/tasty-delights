package com.util;

import com.controller.DatabaseConnection;
import com.interfaces.DeliveryOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeliveryOrderDatabaseUtil implements DeliveryOrder {

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
}
