package com.controller.customer;

import com.model.Customer;
import com.util.CustomerDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageCustomerGet", value = "/ManageCustomerGet")
public class ManageCustomerGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            CustomerDatabaseUtil getCustomers = new CustomerDatabaseUtil();
            ArrayList<Customer> customers = getCustomers.getCustomers();

            request.setAttribute("customers", customers);
            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-customers.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
