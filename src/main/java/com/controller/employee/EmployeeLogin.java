package com.controller.employee;

import com.util.EmployeeDatabaseUtil;
import com.interfaces.EmployeeDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmployeeLogin", value = "/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            EmployeeDatabase empDB = new EmployeeDatabaseUtil();
            boolean flag = empDB.checkLogin(username, password);

            if(flag == true){
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
