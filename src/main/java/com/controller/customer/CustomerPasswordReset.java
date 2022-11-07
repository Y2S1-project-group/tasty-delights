package com.controller.customer;

import com.util.CustomerDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CustomerPasswordReset", value = "/CustomerPasswordReset")
public class CustomerPasswordReset extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String email = request.getParameter("email");
            String newPassword = request.getParameter("new-password");

            CustomerDatabaseUtil customerDatabaseUtil = new CustomerDatabaseUtil();
            boolean value = customerDatabaseUtil.changePassword(email, newPassword);

            if(value == true){
                request.setAttribute("resetStatus", "pass");
                RequestDispatcher dis = request.getRequestDispatcher("./customer-reset-password.jsp");
                dis.forward(request, response);
            }else{
                request.setAttribute("resetStatus", "fail");
                RequestDispatcher dis = request.getRequestDispatcher("./customer-login.jsp");
                dis.forward(request, response);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
