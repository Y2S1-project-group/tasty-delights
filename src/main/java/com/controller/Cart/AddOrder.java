package com.controller.Cart;

import com.model.Order;
import com.model.OrderItem;
import com.util.OrderDatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddOrder", value = "/AddOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("cusid"));
        System.out.println(request.getParameter("tprice").replaceAll("\\s+",""));
        String temp = request.getParameter("orderItemAmount");
        System.out.println("rr");
        System.out.println(temp.substring(0));
        int cusid = Integer.parseInt(request.getParameter("cusid"));
        double tprice = Double.parseDouble(request.getParameter("tprice"));
        int orderItemAmount = Integer.parseInt(request.getParameter("orderItemAmount"));;



        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderDatabaseUtil newOrder = new OrderDatabaseUtil();

        newOrder.insertOrder(cusid ,tprice );
        for( int i = 0; i < orderItemAmount; i++){
            newOrder.insertOrderItem(orderItems.get(i).getName(), orderItems.get(i).getQuantity() , orderItems.get(i).getPrice());
        }
    }
}
