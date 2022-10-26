package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrdersDelivering", value = "/ManageOrdersDelivering")
public class ManageOrdersDelivering extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
        ArrayList<Order> orders = orderProcess.getDeliveringOrders();
        request.setAttribute("orders", orders);

        RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders-delivering.jsp");
        dis.forward(request, response);
    }
}
