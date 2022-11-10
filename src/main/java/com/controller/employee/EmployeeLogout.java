package com.controller.employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "EmployeeLogout", value = "/EmployeeLogout")
public class EmployeeLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            for(Cookie cookie: request.getCookies()){
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
            }

            HttpSession session = request.getSession();
            session.removeAttribute("username");
            session.invalidate();
            response.sendRedirect("employee.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
