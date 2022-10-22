package com.employee;

import com.connection.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            DatabaseConnection object = DatabaseConnection.getInstance();
            Connection conn = object.getConnection();
            Statement st = conn.createStatement();
            String query = String.format("select * from Admin where username = '%s' and password = '%s'", username, password);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int count = rs.getRow();
            rs.close();

            if(count == 1){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("./employee-dashboard.jsp");
            }else{
                response.sendRedirect("./employee.jsp");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
