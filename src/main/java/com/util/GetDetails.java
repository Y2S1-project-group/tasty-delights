package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDetails {
	public ResultSet getDetails() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		Statement st =con.createStatement();
		String query="select * from delivery_person;";
		ResultSet rs = st.executeQuery(query);
		
		return rs;
	}
	
	public ResultSet getDetails(String ids) throws SQLException {
		int id =Integer.parseInt(ids);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		Statement st =con.createStatement();
		String query="select * from delivery_person where id="+id;
		ResultSet rs = st.executeQuery(query);
		
		return rs;
	}
}
