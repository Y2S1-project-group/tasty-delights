package com.controller.customer;

import com.util.CartDatabaseUtil;
import com.util.CustomerDatabaseUtil;
import com.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CustomerUpdateEmployee", value = "/CustomerUpdateEmployee")
public class CustomerUpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            CustomerDatabaseUtil cusUtil = new CustomerDatabaseUtil();

            String cid = request.getParameter("id");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String age = request.getParameter("age");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");

            if(cusUtil.updateCustomer(cid, firstName, lastName, age, email, contact, address)){
                request.setAttribute("empCusUpdateStatus", "success");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManageCustomerGet");
                requestDispatcher.forward(request, response);
            }else{
                request.setAttribute("empCusUpdateStatus", "fail");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManageCustomerGet");
                requestDispatcher.forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
