package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrders", value = "/ManageOrders")
public class ManageOrdersGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
            ArrayList<Order> orders = orderProcess.getOrders();
            request.setAttribute("orders", orders);

            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
