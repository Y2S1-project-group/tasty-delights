package com.controller.Cart;

import com.util.CartDatabaseUtil;
import com.model.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MinusCartItemQuantity", value = "/MinusCartItemQuantity")
public class MinusCartItemQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int cartid = Integer.parseInt(req.getParameter("cartid"));
        CartDatabaseUtil cart = new CartDatabaseUtil();
        int res = cart.minItem(id , cartid);

        if(res > 0)
            req.setAttribute("result", "pass");

        else
            req.setAttribute("result", "fail");

        RequestDispatcher dis = req.getRequestDispatcher("./cart.jsp");
        dis.forward(req, resp);

    }


}
