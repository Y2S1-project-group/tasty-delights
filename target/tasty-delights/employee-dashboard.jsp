
<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/22/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
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
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
