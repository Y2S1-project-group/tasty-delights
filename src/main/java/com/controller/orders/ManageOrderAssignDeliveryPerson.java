package com.controller.orders;

import com.model.DeliveryPerson;
import com.util.DeliveryPersonDatabaseUtil;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageOrderAssignDeliveryPerson", value = "/ManageOrderAssignDeliveryPerson")
public class ManageOrderAssignDeliveryPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DeliveryPersonDatabaseUtil deliveryProcess = new DeliveryPersonDatabaseUtil();
            ArrayList<DeliveryPerson> deliveryPersons = deliveryProcess.getDeliveryPersons();
            request.setAttribute("deliveryPersons", deliveryPersons);

            RequestDispatcher dis = request.getRequestDispatcher("./employee-manage-orders-preparing-assign.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
