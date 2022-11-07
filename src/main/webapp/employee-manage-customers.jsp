<%@ page import="com.model.Customer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 11/3/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
  <title>Employee- Manage Customer</title>
</head>
<body>
<%
  // HTTP 1.1
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  // HTTP 1.0
  response.setHeader("Pragma", "no-cache");
  // Proxies
  response.setHeader("Expires", "0");
  if (session.getAttribute("username") == null) {
    response.sendRedirect("./employee.jsp");
  }
%>
<h2 class="display-3 text-center">Manage Customer</h2>
<%
  ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
  if(customers.size() > 0){
%>
<div class="container">
  <table class="table">
    <thead>
    <tr>
      <th scope="col">CID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Contact</th>
      <th scope="col">Address</th>
    </tr>
    </thead>
    <tbody>
      <%
                for(int i = 0; i < customers.size(); i++) {
                    out.print("<tr>" +
                        "<td>" + customers.get(i).getId() + "</td>" +
                        "<td>" + customers.get(i).getFname() + "</td>" +
                        "<td>" + customers.get(i).getEmail() + "</td>" +
                        "<td>" + customers.get(i).getLname() + "</td>" +
                        "<td>" + customers.get(i).getContact() + "</td>" +
                        "<td>" + customers.get(i).getAddress() + "</td>" +
                        "</tr>");
                }
        out.print("</tbody></table>");
    }else{%>
    <div class="container alert alert-primary" role="alert">
      <p class="text-center">No customers!</p>
    </div>
      <%}%>
</div>
</body>
</html>