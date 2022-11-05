package com.controller.items;

import com.model.Item;
import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ItemsCreate", value = "/ItemsCreate")
public class ItemsCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ItemDatabaseUtil itemCreate = new ItemDatabaseUtil();

            String name = request.getParameter("item-name");
            double price = Integer.parseInt(request.getParameter("price"));
            String image = request.getParameter("image");
            String description = request.getParameter("description");
            String category = request.getParameter("category");

            if (itemCreate.createItems(name, description, category, price,image)){
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
