package com.controller.items;

import com.util.ItemDatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemsDelete", value = "/ItemsDelete")
public class ItemsDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            ItemDatabaseUtil itemUpdate = new ItemDatabaseUtil();
            if(itemUpdate.deleteAnItem(id)){
                request.setAttribute("deleteStatus", "success");
            }else{
                request.setAttribute("deleteStatus", "fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("ItemsGet");
            req.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
