package com.controller.delivery;

import com.model.DeliveryPerson;
import com.model.Item;
import com.util.DeliveryOrderDatabaseUtil;
import com.util.DeliveryPersonDatabaseUtil;
import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeliveryUpdate", value = "/DeliveryUpdate")
public class DeliveryUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int itemId = Integer.parseInt(request.getParameter("id"));
            DeliveryPersonDatabaseUtil deliveryProcess = new DeliveryPersonDatabaseUtil();
            DeliveryPerson Dperson = deliveryProcess.getAnDelivery(itemId);
            request.setAttribute("Dperson", Dperson);

            RequestDispatcher dis = request.getRequestDispatcher("./admin-manage-delivery-update.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
