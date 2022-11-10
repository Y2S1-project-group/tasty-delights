package com.controller.customer;

import com.util.CustomerDatabaseUtil;
import com.util.CartDatabaseUtil;
import com.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerCreateAccount", value = "/CustomerCreateAccount")
public class CustomerCreateAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            PasswordUtil passwordUtil = new PasswordUtil();
            CustomerDatabaseUtil cusUtil = new CustomerDatabaseUtil();
            CartDatabaseUtil newcart = new CartDatabaseUtil();

            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String age = request.getParameter("age");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            String hashPassword = passwordUtil.encryptString(request.getParameter("password"));



            if(cusUtil.createCustomer(firstName, lastName, age, email, contact, address, hashPassword)){
                newcart.addNewCart(firstName,lastName,email);
                response.sendRedirect("./customer-login.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

