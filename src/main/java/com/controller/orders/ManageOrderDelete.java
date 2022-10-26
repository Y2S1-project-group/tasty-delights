package com.controller.orders;

import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManageOrderDelete", value = "/ManageOrderDelete")
public class ManageOrderDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            OrderDatabaseUtil orderUpdate = new OrderDatabaseUtil();
            orderUpdate.deleteAnOrder(id);

            response.sendRedirect("ManageOrdersPending");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
