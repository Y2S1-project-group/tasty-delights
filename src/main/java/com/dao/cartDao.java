package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.controller.DatabaseConnection;
import com.interfaces.Cart;
import com.model.CartItem;

import java.sql.Connection;
import java.util.Arrays;

public class cartDao implements Cart {

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

    public ArrayList<CartItem> displayCart(int cid) {
        ArrayList<CartItem> disCart = new ArrayList<CartItem>();
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
                float price = rs.getFloat("price");
                CartItem temp = new CartItem(id , cartid , iname , quantity , price);
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
