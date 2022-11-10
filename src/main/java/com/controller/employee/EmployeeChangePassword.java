package com.controller.employee;

import com.util.EmployeeDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmployeeChangePassword", value = "/EmployeeChangePassword")
public class EmployeeChangePassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        EmployeeDatabaseUtil employeeDatabaseUtil = new EmployeeDatabaseUtil();
        boolean status = employeeDatabaseUtil.updatePassword(password);
        if(status == true){
            System.out.println("success");
            request.setAttribute("resetPasswordStatus", "success");
            RequestDispatcher dis = request.getRequestDispatcher("./employee-change-password.jsp");
            dis.forward(request, response);
        }else{
            System.out.println("fail");
            request.setAttribute("resetPasswordStatus", "fail");
            RequestDispatcher dis = request.getRequestDispatcher("./employee-change-password.jsp");
            dis.forward(request, response);
        }
    }
}
