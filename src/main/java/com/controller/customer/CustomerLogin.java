package com.controller.customer;

import com.interfaces.EmployeeDatabase;
import com.util.CustomerDatabaseUtil;
import com.util.EmployeeDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerLogin", value = "/CustomerLogin")
public class CustomerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            CustomerDatabaseUtil cusDB = new CustomerDatabaseUtil();
            boolean flag = cusDB.checkLogin(email, password);

            if(flag == true){
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("firstname", cusDB.getCustomerFirstName(email));
                session.setAttribute("lastname", cusDB.getCustomerLastName(email));
                session.setAttribute("cid", cusDB.getCustomerID(email));
                response.sendRedirect("./index.jsp");
            }else{
                response.sendRedirect("./customer-login.jsp");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
