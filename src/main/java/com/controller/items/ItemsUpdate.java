package com.controller.items;

import com.model.Item;
import com.util.ItemDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ItemsUpdate", value = "/ItemsUpdate")
public class ItemsUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int itemId = Integer.parseInt(request.getParameter("id"));
            ItemDatabaseUtil itemProcess = new ItemDatabaseUtil();
            ArrayList<Item> items = itemProcess.getAnItem(itemId);
            request.setAttribute("items", items);

            RequestDispatcher dis = request.getRequestDispatcher("./admin-manage-items-update.jsp");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
