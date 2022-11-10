package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import com.util.ContactUsDatabaseUtil;

@WebServlet(name = "ContactForm", value = "/ContactForm")
public class ContactForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        ContactUsDatabaseUtil contact = new ContactUsDatabaseUtil();
        int res = contact.addContactUsForm(name ,phone , email , message);
    }
}
