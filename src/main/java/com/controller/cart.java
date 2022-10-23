package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.dao.cartDao;
import com.model.cartItem;

@WebServlet(name = "cart", value = "/cart")
public class cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //display cart
        cartDao cart = new cartDao();
        int cartid = 0;
        try {
            cartid = cart.getCartId(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<cartItem> disCart =  cart.displayCart(cartid);
        request.setAttribute("cart", disCart);

        RequestDispatcher dis = request.getRequestDispatcher("./cart.jsp");
        dis.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
