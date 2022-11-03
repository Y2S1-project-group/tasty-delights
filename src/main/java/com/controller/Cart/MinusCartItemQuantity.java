package com.controller.Cart;

import com.util.CartDaoDatabaseUtil;
import com.model.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MinusCartItemQuantity", value = "/MinusCartItemQuantity")
public class MinusCartItemQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("rrrrrrrr");
        int id = Integer.parseInt(request.getParameter("id"));
        int cartid = Integer.parseInt(request.getParameter("cartid"));
        CartDaoDatabaseUtil cart = new CartDaoDatabaseUtil();
        int res = cart.minItem(id , cartid);

        if(res > 0){
            System.out.println( "nice " + res + " rows deleted" );
            //request.setAttribute("result", "pass");
        }
        else{
            System.out.println( "works" );
            //request.setAttribute("result", "fail");
        }
        //sessions pass cid
        ArrayList<CartItem> disCart =  cart.displayCart(cartid);
        request.setAttribute("cart", disCart);

        RequestDispatcher dis = request.getRequestDispatcher("./cart.jsp");
        dis.forward(request, response);

    }
}
