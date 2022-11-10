package com.controller.delivery;

import com.model.DeliveryPerson;
import com.model.Item;
import com.util.DeliveryPersonDatabaseUtil;
import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeliveryGet", value = "/DeliveryGet")
public class DeliveryGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DeliveryPerson> Dperson;
        try{
            DeliveryPersonDatabaseUtil deliveryProcess = new DeliveryPersonDatabaseUtil();
            Dperson = deliveryProcess.getDeliveryPersons();
            request.setAttribute("Dperson", Dperson);

            RequestDispatcher dis = request.getRequestDispatcher("./admin-manage-delivery.jsp");
            dis.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
