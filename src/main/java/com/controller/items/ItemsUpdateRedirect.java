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
            double price = Double.parseDouble(request.getParameter("item-price"));
            String description = request.getParameter("item-description");
            String category = request.getParameter("item-category");
            String image = request.getParameter("item-image");

            //print the values
            System.out.println("id"+id);
            System.out.println("name"+name);
            System.out.println("price"+price);
            System.out.println("description"+description);
            System.out.println("category"+category);
            System.out.println("image"+image);


            ItemDatabaseUtil itemUpdate = new ItemDatabaseUtil();
            if(itemUpdate.updateAnItem(id, name, description, category, price, image)){
                request.setAttribute("updateStatus", "success");
                System.out.println("success");
            }else{
                request.setAttribute("updateStatus", "fail");
                System.out.println("fail");
            }
            RequestDispatcher req = request.getRequestDispatcher("ItemsGet");
            req.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
