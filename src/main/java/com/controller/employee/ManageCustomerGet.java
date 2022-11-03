package com.controller.employee;

import com.model.Employee;
import com.util.EmployeeDatabaseUtil;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageCustomerGet", value = "/ManageCustomerGet")
public class ManageCustomerGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDatabaseUtil orderDatabaseUtil = new EmployeeDatabaseUtil();
        ArrayList<Employee> emp = ;
    }
}
