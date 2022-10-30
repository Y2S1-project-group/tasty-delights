package com.controller.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerLogout", value = "/CustomerLogout")
public class CustomerLogout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            session.removeAttribute("email");
            session.invalidate();
            response.sendRedirect("customer-login.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
