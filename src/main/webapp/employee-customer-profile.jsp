<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 11/9/2022
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
    <title>Employee- Customer Profile</title>
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
<h2 class="display-3 text-center">Customer Profile</h2>
<%
    String id = request.getAttribute("id").toString();
    String fname = request.getAttribute("fname").toString();
    String lname = request.getAttribute("lname").toString();
    String age = request.getAttribute("age").toString();
    String email = request.getAttribute("email").toString();
    String contact = request.getAttribute("contact").toString();
    String address = request.getAttribute("address").toString();
%>

<div class="container">
    <form action="CustomerUpdateEmployee" method="get" name="create-account-form" onsubmit="return validateForm()">
        <div class="form-outline mb-4">
            <p>ID: </p>
            <input class="form-control form-control-lg" type="text" name="id" id="id" value="<% out.print(id); %>" hidden><br>
            <p class = "error-message" id="error-id"></p>
        </div>

        <div class="form-outline mb-4">
            <p>First Name: </p>
            <input class="form-control form-control-lg" type="text" name="fname" id="fname" value="<% out.print(fname); %>"><br>
            <p class = "error-message" id="error-fname"></p>
        </div>

        <div class="form-outline mb-4">
            <p>Last Name: </p>
            <input class="form-control form-control-lg" type="text" name="lname" id="lname" value="<% out.print(lname); %>"><br>
            <p class = "error-message" id="error-lname"></p>
        </div>

        <div class="form-outline mb-4">
            <p>Age: </p>
            <input class="form-control form-control-lg" type="text" name="age" id="age" value="<% out.print(age); %>"><br>
            <p class = "error-message" id="error-age"></p>
        </div>

        <div class="form-outline mb-4">
            <p>Email: </p>
            <input class="form-control form-control-lg" type="text" name="email" id="email" value="<% out.print(email); %>"><br>
            <p class = "error-message" id="error-email"></p>
        </div>

        <div class="form-outline mb-4">
            <p>Contact: </p>
            <input class="form-control form-control-lg" type="text" name="contact" id="contact" value="<% out.print(contact); %>"><br>
            <p class = "error-message" id="error-contact"></p>
        </div>

        <div class="form-outline mb-4">
            <p>Address: </p>
            <input class="form-control form-control-lg" type="text" name="address" id="address" value="<% out.print(address); %>"><br>
            <p class = "error-message" id="error-address"></p>
        </div>
        <div>
            <input class="btn btn-primary btn-lg px-5" type="submit" value="Update">
        </div>
    </form>
    <a href="ManageCustomerGet">go back</a>
</div>
<script src="scripts/employee-customer-update.js"></script>
</body>
</html>
