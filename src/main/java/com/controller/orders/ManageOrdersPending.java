package com.controller.orders;

import com.model.Order;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrdersPending", value = "/ManageOrdersPending")
public class ManageOrdersPending extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
        try{
            OrderDatabaseUtil orderProcess = new OrderDatabaseUtil();
            ArrayList<Order> orders = orderProcess.getPendingOrders();
            request.setAttribute("orders", orders);
            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders-pending.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
