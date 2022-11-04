package com.controller.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import com.util.CartDatabaseUtil;
import com.model.CartItem;

@WebServlet(name = "PlusCartItemQuantity", value = "/PlusCartItemQuantity")
public class PlusCartItemQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int cartid = Integer.parseInt(req.getParameter("cartid"));
        CartDatabaseUtil cart = new CartDatabaseUtil();
        int res = cart.plusItem(id,cartid);

        if(res > 0)
            req.setAttribute("result", "pass");

        else
            req.setAttribute("result", "fail");


        RequestDispatcher dis = req.getRequestDispatcher("./cart.jsp");
        dis.forward(req, resp);

    }

}
