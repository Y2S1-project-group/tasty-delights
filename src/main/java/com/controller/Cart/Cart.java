package com.controller.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import com.util.CartDatabaseUtil;
import com.model.CartItem;
import com.mysql.cj.Session;

@WebServlet(name = "cart", value = "/carttemp")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //display cart
        CartDatabaseUtil cart = new CartDatabaseUtil();
        int cartid = 0;
        try {
            HttpSession session = request.getSession();
            cartid = cart.getCartId((Integer) session.getAttribute("cid"));
            System.out.println((Integer) session.getAttribute("cid"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dis = request.getRequestDispatcher("./cart.jsp");
        dis.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
