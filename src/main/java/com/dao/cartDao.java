package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.controller.DatabaseConnection;
import com.interfaces.cart;
import com.model.cartItem;

import java.sql.Connection;
import java.util.Arrays;

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
        return rs.getInt("id");
    }

    public ArrayList<cartItem> displayCart(int cid) {
        ArrayList<cartItem> disCart = new ArrayList<cartItem>();
        try{
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            String query =  String.format("SELECT * FROM cart_item where cartid = %d" , cid);
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                int cartid = rs.getInt("cartid");
                String iname = rs.getString("iname");
                int quantity = rs.getInt("quantity");
                cartItem temp = new cartItem(id , cartid , iname , quantity);
                disCart.add(temp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return disCart;
    }

    public boolean deleteCartItem(int id , int cartId){

        String query =  String.format("SELECT * FROM cart_item where cartid = %d" , cartId);
        return false;
    }


}
