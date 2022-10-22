
<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/22/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee- Dashboard</title>
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
    <h1>Welcome to the admin panel</h1>
    <form action="EmployeeLogout" method="post">
        <input type="submit" value="logout">
    </form>
</body>
</html>
