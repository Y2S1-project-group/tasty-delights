package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDetails {
	public ResultSet orderDetails() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tasty_delights","root","shashINI3380.");
		Statement st =con.createStatement();
		String query="SELECT d.id, d.order_id, d.status, dp.name FROM delivery_order d, delivery_person dp WHERE d.did=dp.id;";
		ResultSet rs = st.executeQuery(query);
		
		return rs;
	}
}
