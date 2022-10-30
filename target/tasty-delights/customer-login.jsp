<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <form name="login-form" action="CustomerLogin" method="post" onsubmit="return validateForm();">
        <p class = "error-message login-invalid" id="error-login"></p>
        Email <input placeholder = "Enter the email address" name = "email" id="login-email"><br>
        <p class = "error-message" id="error-email"></p>
        Password <input type = "password" placeholder = "Enter the password" name = "password" id = "login-password"><br>
        <p class = "error-message" id="error-pass"></p>
        <input type="submit" name="login" value="Log In">
    </form>
    <a href="customer-register.jsp">I don't have an account</a>
    <a href="customer-reset-password.jsp">forgot password</a>
    <script src="scripts/customer-login.js"></script>
</body>
</html>
