package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.connection.DatabaseConnection;
import com.interfaces.cart;
import com.model.cartItem;

import java.sql.Connection;

public class cartDao implements cart {

    public int getCartId(int id) throws Exception {

        String getCartId = "SELECT * FROM cart where cusid = ?";
        int result;

        DatabaseConnection object = DatabaseConnection.getInstance();
        Connection conn = object.getConnection();
        Statement st = conn.createStatement();

        PreparedStatement preparedStatement = conn.prepareStatement(getCartId);
        preparedStatement.setInt(1, 1);

        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        System.out.println(rs.getInt("id"));
        return 0;
    }

    public ArrayList<cartItem> displayCart(int id) {

        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            String query =  String.format("SELECT * FROM cartItem where id = '%d'" , id);
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String cartid = rs.getInt("cartid");
                String iname = rs.getString("iname");
                int quantity = rs.getInt("quantity");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
