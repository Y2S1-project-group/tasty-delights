package com.controller.orders;

import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManageOrderPrepare", value = "/ManageOrderPrepare")
public class ManageOrderPrepare extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            OrderDatabaseUtil orderStatus = new OrderDatabaseUtil();
            orderStatus.updateOrderStatus(id, "preparing");

            response.sendRedirect("ManageOrdersPending");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
