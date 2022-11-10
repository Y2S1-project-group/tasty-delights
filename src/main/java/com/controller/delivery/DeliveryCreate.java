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
import java.util.logging.Logger;

@WebServlet(name = "DeliveryCreate", value = "/DeliveryCreate")
public class DeliveryCreate extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DeliveryPersonDatabaseUtil deliveryCreate = new DeliveryPersonDatabaseUtil();

            String name = request.getParameter("item-name");
            int age = Integer.parseInt(request.getParameter("item-age"));
            String contact = request.getParameter("item-contact");
            String email = request.getParameter("item-email");
            String username = request.getParameter("item-username");
            String password = request.getParameter("item-password");

            if (deliveryCreate.addDeliveryPerson(name, age,contact, email, username, password)){
                System.out.println("Delivery Person Added");
                request.setAttribute("createStatus", "success");
            }else{
                System.out.println("Delivery Person Not Added");
                request.setAttribute("createStatus", "fail");

            }

            RequestDispatcher dis = request.getRequestDispatcher("DeliveryGet");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
