package com.controller.Cart;

import com.util.CartDatabaseUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/AddToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartid = Integer.parseInt(request.getParameter("cartid"));
        String iname = request.getParameter("iname");
        double price = Double.parseDouble(request.getParameter("price"));

        CartDatabaseUtil cart = new CartDatabaseUtil();
        int res = cart.addToCart(cartid, iname , price);

        if(res > 0)
            request.setAttribute("result", "pass");

        else
            request.setAttribute("result", "fail");

        RequestDispatcher dis = request.getRequestDispatcher("./index.jsp");
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
