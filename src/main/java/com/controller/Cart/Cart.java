package com.controller.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.util.CartDatabaseUtil;
import com.model.CartItem;

@WebServlet(name = "cart", value = "/carttemp")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //display cart
        CartDatabaseUtil cart = new CartDatabaseUtil();
        int cartid = 0;
        try {
            cartid = cart.getCartId(1); // sessions
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<CartItem> disCart =  cart.displayCart(cartid);
        request.setAttribute("cart", disCart);

        RequestDispatcher dis = request.getRequestDispatcher("./cart.jsp");
        dis.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
