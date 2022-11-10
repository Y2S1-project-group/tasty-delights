package com.controller.delivery;

import com.model.Item;
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
            ItemDatabaseUtil itemProcess = new ItemDatabaseUtil();
            Item items = itemProcess.getAnItem(itemId);
            request.setAttribute("items", items);

            RequestDispatcher dis = request.getRequestDispatcher("./admin-manage-items-update.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
