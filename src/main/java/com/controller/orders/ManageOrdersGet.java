package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrdersGet", value = "/ManageOrdersGet")
public class ManageOrdersGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
            ArrayList<Order> pending = orderProcess.getPendingOrders();
            ArrayList<Order> preparing = orderProcess.getPreparingOrders();
            ArrayList<Order> delivering = orderProcess.getDeliveringOrders();
            ArrayList<Order> completed = orderProcess.getCompletedOrders();

            request.setAttribute("pending", pending);
            request.setAttribute("preparing", preparing);
            request.setAttribute("delivering", delivering);
            request.setAttribute("completed", completed);

            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
