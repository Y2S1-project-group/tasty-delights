package com.controller.Cart;

import com.model.Order;
import com.model.OrderItem;
import com.model.CartItem;
import com.util.OrderDatabaseUtil;
import com.util.CartDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddOrder", value = "/AddOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cusid = Integer.parseInt(request.getParameter("cusid").trim());
        double tprice = Double.parseDouble(request.getParameter("tprice"));
        int orderItemAmount = Integer.parseInt(request.getParameter("orderItemAmount").trim());


        CartDatabaseUtil newCart = new CartDatabaseUtil();
        ArrayList<CartItem> cartItems = newCart.displayCart(cusid);

        OrderDatabaseUtil newOrder = new OrderDatabaseUtil();

        newOrder.insertOrder(cusid ,tprice );
        System.out.println("rrrrrr" + newOrder.getLastOrderId() );
        for( int i = 0; i < orderItemAmount; i++){
            newOrder.insertOrderItem( newOrder.getLastOrderId(), cartItems.get(i).getIname(), cartItems.get(i).getQuantity() , cartItems.get(i).getPrice());
        }

        RequestDispatcher dis = request.getRequestDispatcher("./index.jsp");
        dis.forward(request, response);
    }
}
