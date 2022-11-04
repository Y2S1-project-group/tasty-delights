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

@WebServlet(name = "ItemsSearch", value = "/ItemsSearch")
public class ItemsSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ItemDatabaseUtil itemProcess = new ItemDatabaseUtil();
            String searchQuery = request.getParameter("searchQuery");
            ArrayList<Item> search = itemProcess.searchItems(searchQuery);
            request.setAttribute("searchQuery", searchQuery);

            RequestDispatcher dis = request.getRequestDispatcher("ItemsGet");
            dis.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
