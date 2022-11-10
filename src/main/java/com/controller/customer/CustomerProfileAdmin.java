package com.controller.customer;

import com.model.Customer;
import com.util.CustomerDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CustomerProfileAdmin", value = "/CustomerProfileAdmin")
public class CustomerProfileAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            CustomerDatabaseUtil customerDatabaseUtil = new CustomerDatabaseUtil();
            Customer customer = customerDatabaseUtil.getCustomer(id);

            request.setAttribute("id", customer.getId());
            request.setAttribute("fname", customer.getFname());
            request.setAttribute("lname", customer.getLname());
            request.setAttribute("age", customer.getAge());
            request.setAttribute("email", customer.getEmail());
            request.setAttribute("contact", customer.getContact());
            request.setAttribute("address", customer.getAddress());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./employee-customer-profile.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
