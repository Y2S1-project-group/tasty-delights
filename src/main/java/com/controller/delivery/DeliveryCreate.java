package com.controller.delivery;

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
            ItemDatabaseUtil itemCreate = new ItemDatabaseUtil();

            String name = request.getParameter("item-name");
            double price = Double.parseDouble(request.getParameter("item-price"));
            String image = request.getParameter("item-image");
            String description = request.getParameter("item-description");
            String category = request.getParameter("item-category");

            if (itemCreate.createItems(name, price, image)){
                request.setAttribute("createStatus", "success");
            }else{
                request.setAttribute("createStatus", "fail");

            }

            RequestDispatcher dis = request.getRequestDispatcher("ItemsGet");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
