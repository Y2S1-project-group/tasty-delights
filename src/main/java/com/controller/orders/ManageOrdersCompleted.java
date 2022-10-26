package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrdersCompleted", value = "/ManageOrdersCompleted")
public class ManageOrdersCompleted extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
        ArrayList<Order> orders = orderProcess.getCompletedOrders();
        request.setAttribute("orders", orders);

        RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders-completed.jsp");
        dis.forward(request, response);
    }
}
