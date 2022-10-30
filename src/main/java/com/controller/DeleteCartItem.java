package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.dao.*;

@WebServlet(name = "deleteCartItem", value = "/deleteCartItem")
public class DeleteCartItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int cartid = Integer.parseInt(request.getParameter("cartid"));
        cartDao cart = new cartDao();
        cart.deleteCartItem( id,cartid);
    }
}
