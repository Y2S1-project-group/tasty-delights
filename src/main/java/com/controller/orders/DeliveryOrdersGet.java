package com.controller.orders;

import com.model.DeliveryOrder;
import com.util.DeliveryOrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeliveryOrdersGet", value = "/DeliveryOrdersGet")
public class DeliveryOrdersGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DeliveryOrder> deliveryOrders;
        try{
            DeliveryOrderDatabaseUtil deliveryOrderDatabaseUtil = new DeliveryOrderDatabaseUtil();
            deliveryOrders = deliveryOrderDatabaseUtil.getDeliveryOrders();

            request.setAttribute("deliveryOrders", deliveryOrders);
            RequestDispatcher dis = request.getRequestDispatcher("./delivery-person-dashboard.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
