package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.DeliveryUsers;


public class InsertUser {
	
	public void addUserdb(DeliveryUsers user) throws SQLException{
		 String nic= user.getNic();
	     String name= user.getName();
	     String dob= user.getDob();
	     String age= user.getAge();
	     String gender= user.getGender();
	     String contact= user.getContact();
	     String email= user.getEmail();
	     String job_position= user.getJob_position();
	     String user_name= user.getUser_name();
	     String password= user.getPassword();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		PreparedStatement ps =con.prepareStatement("INSERT INTO delivery_person ( nic ,name ,dob ,age ,gender ,email ,contact ,job_position ,user_name ,password ) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? );");
		ps.setString(1, nic);
		ps.setString(2, name);
		ps.setString(3, dob);
		ps.setString(4, age);
		ps.setString(5, gender);
		ps.setString(6, contact);
		ps.setString(7, email);
		ps.setString(8, job_position);
		ps.setString(9, user_name);
		ps.setString(10, password);
		
		 ps.execute();
		
	}

	
}
