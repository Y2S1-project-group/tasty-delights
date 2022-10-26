package com.controller.orders;

import com.util.DeliveryOrderDatabaseUtil;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManageOrderAssignDeliveryPersonRedirect", value = "/ManageOrderAssignDeliveryPersonRedirect")
public class ManageOrderAssignDeliveryPersonRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int did = Integer.parseInt(request.getParameter("did"));
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            DeliveryOrderDatabaseUtil deliveryOrder = new DeliveryOrderDatabaseUtil();
            deliveryOrder.addOrderToDelivery(orderId);

            OrderDatabaseUtil orderUpdate = new OrderDatabaseUtil();
            orderUpdate.updateOrderStatus(orderId, "delivering");

            response.sendRedirect("ManageOrdersPreparing");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
