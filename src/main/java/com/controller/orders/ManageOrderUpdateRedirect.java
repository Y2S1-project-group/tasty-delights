package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrderUpdateRedirect", value = "/ManageOrderUpdateRedirect")
public class ManageOrderUpdateRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("itemname");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));

            OrderDatabaseUtil orderUpdate = new OrderDatabaseUtil();
            orderUpdate.updateAnOrder(id, name, quantity, price);

            response.sendRedirect("ManageOrdersPending");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
