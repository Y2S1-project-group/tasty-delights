package com.controller.items;

import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemsUpdateRedirect", value = "/ItemsUpdateRedirect")
public class ItemsUpdateRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("item-name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int price = Integer.parseInt(request.getParameter("price"));

            ItemDatabaseUtil itemUpdate = new ItemDatabaseUtil();
            if(itemUpdate.updateAnItem(id, name, quantity, price)){
                request.setAttribute("updateStatus", "success");
            }else{
                request.setAttribute("updateStatus", "fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("ItemsGet");
            req.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
