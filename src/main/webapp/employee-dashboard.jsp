
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

        int totalCustomers = 0;
        int totalListedItems = 0;
        double totalSales = 0;
        int pendingOrdersCount = 0;
        int preparingOrderCount = 0;
        int deliveringOrderCount = 0;
        String currentTime = "";
        try {
            totalCustomers = (int) request.getAttribute("totalCustomers");
            totalListedItems = (int) request.getAttribute("totalListedItems");
            totalSales = (double) request.getAttribute("totalSales");
            pendingOrdersCount = (int) request.getAttribute("pendingOrdersCount");
            preparingOrderCount = (int) request.getAttribute("preparingOrderCount");
            deliveringOrderCount = (int) request.getAttribute("deliveringOrderCount");
            currentTime = request.getAttribute("currentTime").toString();
        } catch (Exception e) {
            e.printStackTrace();
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
                    <h2 class="card-title text-center">Total Customers</h2>
                    <h4 class="text-danger text-center"><% out.print(totalCustomers); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Total Listed Items</h2>
                    <h4 class="text-danger text-center"><% out.print(totalListedItems); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Total Sales</h2>
                    <h4 class="text-danger text-center">Rs: <% out.print(totalSales); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
        </div>
        <%-- second row --%>
        <div class="card-deck">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Pending Orders Count</h2>
                    <h4 class="text-danger text-center"><% out.print(pendingOrdersCount); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Preparing Order Count</h2>
                    <h4 class="text-danger text-center"><% out.print(preparingOrderCount); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Delivering Order Count</h2>
                    <h4 class="text-danger text-center"><% out.print(deliveringOrderCount); %></h4>
                </div>
                <div class="card-footer">
                    <small class="text-muted">Last updated: <% out.print(currentTime); %></small>
                </div>
            </div>
        </div>
    </div>
</body>
</html>