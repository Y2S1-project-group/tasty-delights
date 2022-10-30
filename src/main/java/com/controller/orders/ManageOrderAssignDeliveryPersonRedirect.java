package com.controller.orders;

import com.model.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
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
            OrderDatabaseUtil orderUpdate = new OrderDatabaseUtil();

            if(deliveryOrder.addOrderToDelivery(did, orderId)){
                if(orderUpdate.updateOrderStatus(orderId, "delivering")){
                    request.setAttribute("assignStatus", "success");
                }else{
                    request.setAttribute("assignStatus", "fail");
                }
            }else{
                request.setAttribute("assignStatus", "fail");
            }

            RequestDispatcher req = request.getRequestDispatcher("ManageOrdersPreparing");
            req.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
