package com.controller.employee;

import com.util.EmployeeDatabaseUtil;
import com.interfaces.EmployeeDatabase;
import com.util.StatsDatabaseUtil;
import javax.servlet.http.Cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmployeeLogin", value = "/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            EmployeeDatabase empDB = new EmployeeDatabaseUtil();
            boolean flag = empDB.checkLogin(username, password);

            if(flag == true){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.setContentType("text/html");

                StatsDatabaseUtil statsDatabaseUtil = new StatsDatabaseUtil();
                Cookie totalCustomers = new Cookie("totalCustomers", String.valueOf(statsDatabaseUtil.totalCustomers()));
                Cookie totalListedItems = new Cookie("totalListedItems", String.valueOf(statsDatabaseUtil.totalListedItems()));
                Cookie totalSales = new Cookie("totalSales", String.valueOf(statsDatabaseUtil.totalSales()));
                Cookie pendingOrdersCount = new Cookie("pendingOrdersCount", String.valueOf(statsDatabaseUtil.pendingOrdersCount()));
                Cookie preparingOrderCount = new Cookie("preparingOrderCount", String.valueOf(statsDatabaseUtil.preparingOrderCount()));
                Cookie deliveringOrderCount = new Cookie("deliveringOrderCount", String.valueOf(statsDatabaseUtil.deliveringOrderCount()));
                Cookie currentTime = new Cookie("currentTime", statsDatabaseUtil.getCurrentTime());

                response.addCookie(totalCustomers);
                response.addCookie(totalListedItems);
                response.addCookie(totalSales);
                response.addCookie(pendingOrdersCount);
                response.addCookie(preparingOrderCount);
                response.addCookie(deliveringOrderCount);
                response.addCookie(currentTime);

                response.sendRedirect("./employee-dashboard.jsp");
            }else{
                request.setAttribute("loginError", "loginError");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./employee.jsp");
                requestDispatcher.forward(request, response);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
