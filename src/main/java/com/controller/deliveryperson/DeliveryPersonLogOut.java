package com.controller.deliveryperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeliveryPersonLogOut", value = "/DeliveryPersonLogOut")
public class DeliveryPersonLogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            session.removeAttribute("email");
            session.invalidate();
            response.sendRedirect("./delivery-person.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
