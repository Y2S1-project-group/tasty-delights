package com.controller.orders;

import com.model.Order;
import com.model.OrderItem;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrderViewItems", value = "/ManageOrderViewItems")
public class ManageOrderViewItems extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int orderId = Integer.parseInt(request.getParameter("id"));
            OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
            ArrayList<OrderItem> items = orderProcess.getAnOrderItems(orderId);
            request.setAttribute("items", items);

            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders-item-view.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
