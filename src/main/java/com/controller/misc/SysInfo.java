package com.controller.misc;

import java.util.Properties;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SysInfo", value = "/SysInfo")
public class SysInfo extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = getServletContext().getResourceAsStream("/WEB-INF/server.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String version = prop.getProperty("version");
            String user1 = prop.getProperty("user1");
            String user2 = prop.getProperty("user2");
            String user3 = prop.getProperty("user3");
            String user4 = prop.getProperty("user4");
            request.setAttribute("version", version);
            request.setAttribute("user1", user1);
            request.setAttribute("user2", user2);
            request.setAttribute("user3", user3);
            request.setAttribute("user4", user4);

        } catch (IOException ex) {
            //ex.printStackTrace();
            out.println(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            RequestDispatcher dis = request.getRequestDispatcher("./system-info.jsp");
            dis.forward(request, response);
        }
    }
}
