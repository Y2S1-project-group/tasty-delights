package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


public class checkLogin {
	
	public ResultSet checkAdmin(User user) throws SQLException{
		String uname = user.getUname();
		String pass = user.getPass();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		PreparedStatement ps =con.prepareStatement("select * from admin WHERE username=? and password=?");  
		ps.setString(1, uname);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		return rs;
		
		
		
	}
	
	public ResultSet  checkUser(User user) throws SQLException{
		String uname = user.getUname();
		String pass = user.getPass();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		PreparedStatement ps =con.prepareStatement("select * from delivery_person WHERE user_name=? and password=?");  
		ps.setString(1, uname);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		return rs;
		
		
		
	}

}
