package com.controller.delivery;

import com.util.DeliveryPersonDatabaseUtil;
import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeliveryDelete", value = "/DeliveryDelete")
public class DeliveryDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            DeliveryPersonDatabaseUtil deliveryUpdate = new DeliveryPersonDatabaseUtil();
            if(deliveryUpdate.deleteADelivery(id)){
                request.setAttribute("deleteStatus", "success");
            }else{
                request.setAttribute("deleteStatus", "fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("DeliveryGet");
            req.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
