<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body>
    <h1>Create an account</h1>
    <form action="CustomerCreateAccount" method="post" name="create-account-form" onsubmit="return validateForm()">
        First Name <input type="text" name="fname" id="fname"><br>
        <p class = "error-message" id="error-fname"></p>
        Last Name <input type="text" name="lname" id="lname"><br>
        <p class = "error-message" id="error-lname"></p>
        Age <input type="text"  name="age" id="age"><br>
        <p class = "error-message" id="error-age"></p>
        Email <input type="text"  name="email" id="email"><br>
        <p class = "error-message" id="error-email"></p>
        Contact <input type="text" name="contact" id="contact"><br>
        <p class = "error-message" id="error-contact"></p>
        Address <input type="text" name="address" id="address"><br>
        <p class = "error-message" id="error-address"></p>
        Password <input type="password" name="password" id="password"><br>
        <p class = "error-message" id="error-password"></p>
        Confirm Password <input type="password" name="confirm-password" id="confirm-password"><br>
        <p class = "error-message" id="error-confirm-password"></p>
        <p class = "error-message" id="error-pass-mismatch"></p>
        <input type="submit" value="Register">
    </form>

    <a href="customer-login.jsp">Back to login</a>
    <script src="scripts/customer-register.js"></script>
</body>
</html>
