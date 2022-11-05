package com.controller.Cart;

import com.util.CartDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddOrder", value = "/AddOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String iname = req.getParameter("iname");
        int cartid = Integer.parseInt(req.getParameter("cartid"));
        double price = Double.parseDouble("price");

        CartDatabaseUtil cart = new CartDatabaseUtil();
        int res = cart.addToCart(cartid, iname , price);

        if(res > 0)
            req.setAttribute("result", "pass");

        else
            req.setAttribute("result", "fail");
    }
}
