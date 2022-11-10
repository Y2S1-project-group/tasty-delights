
<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/22/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<%
    request.removeAttribute("loginError");
%>
<html>
<head>
    <title>Employee- Dashboard</title>
    <style>
        .main-container{
            padding-top: 100px;
        }
        .card-deck{
            margin-top: 30px;
        }
    </style>
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
    <div class="container main-container">
        <div class="alert-container alert alert-primary" role="alert">
            <h1 class="text-center">Admin Dashboard</h1>
        </div>
        <%-- first row --%>
        <div class="card-deck">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
        </div>
        <%-- second row --%>
        <div class="card-deck">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Card title</h2>
                    <h4 class="text-danger text-center">Card title</h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
        </div>
    </div>
    <a href="SysInfo" class="sysinfo" >System Info</a>
</body>
</html>
