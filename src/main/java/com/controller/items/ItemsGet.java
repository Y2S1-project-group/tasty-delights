package com.controller.items;

import com.model.Item;
import com.util.ItemDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ItemsGet", value = "/ItemsGet")
public class ItemsGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ItemDatabaseUtil itemProcess = new ItemDatabaseUtil();
            ArrayList<Item> items = itemProcess.getItems();


            request.setAttribute("items", items);

            RequestDispatcher dis = request.getRequestDispatcher("./admin-manage-items.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
