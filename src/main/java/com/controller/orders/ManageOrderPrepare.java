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
            if(orderStatus.updateOrderStatus(id, "preparing")){
                request.setAttribute("prepareStatus", "success");
            }else{
                request.setAttribute("prepareStatus", "fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("ManageOrdersPending");
            req.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
