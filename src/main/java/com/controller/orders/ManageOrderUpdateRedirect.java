package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.RequestDispatcher;
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
            if(orderUpdate.updateAnOrder(id, name, quantity, price)){
                request.setAttribute("updateStatus", "success");
            }else{
                request.setAttribute("updateStatus", "fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("ManageOrdersPending");
            req.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
