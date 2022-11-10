package com.controller.deliveryperson;

import com.util.DeliveryPersonDatabaseUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeliveryPersonLogin", value = "/DeliveryPersonLogin")
public class DeliveryPersonLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            DeliveryPersonDatabaseUtil delDB = new DeliveryPersonDatabaseUtil();
            boolean flag = delDB.checkLogin(email, password);

            if(flag == true){
                javax.servlet.http.HttpSession session = request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("DeliveryOrdersGet");
            }else{
                response.sendRedirect("./delivery-person.jsp");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
