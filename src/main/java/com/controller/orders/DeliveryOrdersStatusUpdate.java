package com.controller.orders;

import com.controller.DatabaseConnection;
import com.util.DeliveryOrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeliveryOrdersStatusUpdate", value = "/DeliveryOrdersStatusUpdate")
public class DeliveryOrdersStatusUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = (String) request.getParameter("id");
            String OrderId = (String) request.getParameter("orderId");
            DeliveryOrderDatabaseUtil deliveryOrderDatabaseUtil = new DeliveryOrderDatabaseUtil();

            if(deliveryOrderDatabaseUtil.updateDeliveryOrderStatus(id, OrderId) == true){
                response.sendRedirect("DeliveryOrdersGet");
            }else{
                response.sendRedirect("DeliveryOrdersGet");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
