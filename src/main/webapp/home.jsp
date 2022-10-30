<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasty Delights</title>
</head>
<body>
    <%
        // HTTP 1.1
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        // HTTP 1.0
        response.setHeader("Pragma", "no-cache");
        // Proxies
        response.setHeader("Expires", "0");
        if (session.getAttribute("email") == null) {
            response.sendRedirect("./customer-login.jsp");
        }
    %>
    <h1>Tasty Delights</h1>
    <a href="CustomerLogout">logout</a>
</body>
</html>
