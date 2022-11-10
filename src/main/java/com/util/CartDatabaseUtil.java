package com.util;
import java.sql.*;
import java.util.ArrayList;
import com.controller.DatabaseConnection;
import com.interfaces.Cart;
import com.model.CartItem;

import java.sql.Connection;

public class CartDatabaseUtil implements Cart {

    public CartDatabaseUtil(){

    }

    public int getCartId(int cusid) throws Exception {

        String getCartId = "SELECT * FROM cart where cusid = ?";
        int result;
        DatabaseConnection object = DatabaseConnection.getInstance();
        Connection conn = object.getConnection();
        Statement st = conn.createStatement();

        PreparedStatement preparedStatement = conn.prepareStatement(getCartId);
        preparedStatement.setInt(1, 1);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
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
                CartItem temp = new CartItem(id , cartid , iname , quantity ,price);
                disCart.add(temp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return disCart;
    }

    public int deleteCartItem(int id , int cartId) {

        String query = String.format("DELETE FROM cart_item where cartid = %d AND id = %d", cartId, id);

        int res = 0;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            res = st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int plusItem(int id , int cartId){
        String query = String.format("UPDATE cart_item SET quantity = quantity + 1 where id = %d AND cartId = %d",id,cartId );
        int res = 0;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            res = st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public int minItem(int id , int cartId){
        String query = String.format("UPDATE cart_item SET quantity = quantity - 1 where id = %d AND cartId = %d",id,cartId );
        int res = 0;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            res = st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int addToCart(int cartid, String iname , double price){

        String query = String.format("INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( %d , '%s' , 1 ,'%f');",cartid ,iname ,price );
        int res = 0;
        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();

            res = st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int addNewCart(String fname , String lname , String email ) throws Exception {
        String query = "SELECT id from customer where fname = ? AND lname = ? AND email = ?";
        int result;
        DatabaseConnection object = DatabaseConnection.getInstance();
        Connection conn = object.getConnection();
        Statement st = conn.createStatement();

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, fname);
        preparedStatement.setString(2, lname);
        preparedStatement.setString(3, email);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int cusid =  rs.getInt("id");
        query = String.format("insert into cart (cusid) values(%d)", cusid);


        int res = st.executeUpdate(query);
        return res;
    }
    public void addOrder(){
        String query = String.format("");
    }
}
