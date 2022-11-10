package com.controller.employee;

import com.util.EmployeeDatabaseUtil;
import com.interfaces.EmployeeDatabase;
import com.util.StatsDatabaseUtil;

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

                StatsDatabaseUtil statsDatabaseUtil = new StatsDatabaseUtil();
                request.setAttribute("totalCustomers", statsDatabaseUtil.totalCustomers());
                request.setAttribute("totalListedItems", statsDatabaseUtil.totalListedItems());
                request.setAttribute("totalSales", statsDatabaseUtil.totalSales());
                request.setAttribute("pendingOrdersCount", statsDatabaseUtil.pendingOrdersCount());
                request.setAttribute("preparingOrderCount", statsDatabaseUtil.preparingOrderCount());
                request.setAttribute("deliveringOrderCount", statsDatabaseUtil.deliveringOrderCount());
                request.setAttribute("currentTime", statsDatabaseUtil.getCurrentTime());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./employee-dashboard.jsp");
                requestDispatcher.forward(request, response);
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
