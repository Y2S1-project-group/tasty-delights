package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.DeliveryUsers;


public class UpdateDetails {
	public void updateDetails(DeliveryUsers user,String ids) throws SQLException {
		int id = Integer.parseInt(ids);
		 String nic= user.getNic();
	     String name= user.getName();
	     String dob= user.getDob();
	     String age= user.getAge();
	     String gender= user.getGender();
	     String contact= user.getContact();
	     String email= user.getEmail();
	     String job_position= user.getJob_position();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		PreparedStatement ps =con.prepareStatement("UPDATE delivery_person SET nic = ? ,name = ? ,dob = ?"
				+ " ,age = ? ,gender = ? ,email = ? ,contact = ? ,job_position = ?  WHERE id = ? ;");
		ps.setString(1, nic);
		ps.setString(2, name);
		ps.setString(3, dob);
		ps.setString(4, age);
		ps.setString(5, gender);
		ps.setString(6, email);
		ps.setString(7, contact);
		ps.setString(8, job_position);
		ps.setInt(9, id);
		
		 ps.execute();
		
	}
	
	public void updateDelivery(String id) throws SQLException {
		int orderid = Integer.parseInt(id);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		PreparedStatement ps =con.prepareStatement("UPDATE delivery_order SET status = 'completed' WHERE id = ?;");
		
		ps.setInt(1, orderid);
		
		 ps.execute();
		
	}
	
}
