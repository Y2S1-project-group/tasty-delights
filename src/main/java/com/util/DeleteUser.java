package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteUser {
	
	public int deleteUser(int id) throws SQLException{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		Statement st =con.createStatement();
		String query="delete from delivery_person where id ="+id;
		int rs=st.executeUpdate(query);
		return rs;	
	}

}
