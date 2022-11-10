package com.controller.Cart;

import com.util.CartDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteCartItem", value = "/DeleteCartItem")
public class DeleteCartItem extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int cartid = Integer.parseInt(req.getParameter("cartid"));
        CartDatabaseUtil cart = new CartDatabaseUtil();
        cart.deleteCartItem( id,cartid);
        RequestDispatcher dis = req.getRequestDispatcher("./cart.jsp");
        dis.forward(req, resp);
    }
}
