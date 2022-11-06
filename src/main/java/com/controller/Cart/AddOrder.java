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

    }
}
