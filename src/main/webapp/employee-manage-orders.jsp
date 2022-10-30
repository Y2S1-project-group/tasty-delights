<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
    <title>Employee- Manage Orders</title>
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
    <%@include file="./employee-manage-orders-header.jsp" %>
    <h2 class="display-3 text-center">Pending Orders</h2>
    <%
        ArrayList<Order> pendingOrders = (ArrayList<Order>) request.getAttribute("pending");
        if(pendingOrders.size() > 0){
    %>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Status</th>
                <th scope="col">Total Price</th>
                <th scope="col">Ordered Time</th>
            </tr>
            </thead>
            <tbody>
    <%
        for(int i = 0; i < pendingOrders.size(); i++) {
                out.print("<tr>" +
                    "<td>" + pendingOrders.get(i).getId() + "</td>" +
                    "<td>" + pendingOrders.get(i).getCusid() + "</td>" +
                    "<td>" + pendingOrders.get(i).getName() + "</td>" +
                    "<td>" + pendingOrders.get(i).getQuality() + "</td>" +
                    "<td>" + pendingOrders.get(i).getStatus() + "</td>" +
                    "<td>" + pendingOrders.get(i).getTprice() + "</td>" +
                    "<td>" + pendingOrders.get(i).getOrderedtime() + "</td>" +
                    "</tr>");
        }
        out.print("</tbody></table>");
    }else{%>
            <div class="container alert alert-primary" role="alert">
                <p class="text-center">No more pending orders!</p>
            </div>
                <%}%>
    </div>

    <h2 class="display-3 text-center">Preparing Orders</h2>
    <%
        ArrayList<Order> preparingOrders = (ArrayList<Order>) request.getAttribute("preparing");
        if(preparingOrders.size() > 0){
    %>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Status</th>
                <th scope="col">Total Price</th>
                <th scope="col">Ordered Time</th>
            </tr>
            </thead>
            <tbody>
                <%
        for(int i = 0; i < preparingOrders.size(); i++) {
                out.print("<tr>" +
                    "<td>" + preparingOrders.get(i).getId() + "</td>" +
                    "<td>" + preparingOrders.get(i).getCusid() + "</td>" +
                    "<td>" + preparingOrders.get(i).getName() + "</td>" +
                    "<td>" + preparingOrders.get(i).getQuality() + "</td>" +
                    "<td>" + preparingOrders.get(i).getStatus() + "</td>" +
                    "<td>" + preparingOrders.get(i).getTprice() + "</td>" +
                    "<td>" + preparingOrders.get(i).getOrderedtime() + "</td>" +
                    "</tr>");
        }
        out.print("</tbody></table>");
    }else{%>
            <div class="container alert alert-primary" role="alert">
                <p class="text-center">No more preparing orders!</p>
            </div>
                <%}%>
    </div>

    <h2 class="display-3 text-center">Delivering Orders</h2>
    <%
        ArrayList<Order> deliveringOrders = (ArrayList<Order>) request.getAttribute("delivering");
        if(deliveringOrders.size() > 0){
    %>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Status</th>
                <th scope="col">Total Price</th>
                <th scope="col">Ordered Time</th>
            </tr>
            </thead>
            <tbody>
                <%
        for(int i = 0; i < deliveringOrders.size(); i++) {
                out.print("<tr>" +
                    "<td>" + deliveringOrders.get(i).getId() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getCusid() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getName() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getQuality() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getStatus() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getTprice() + "</td>" +
                    "<td>" + deliveringOrders.get(i).getOrderedtime() + "</td>" +
                    "</tr>");
        }
        out.print("</tbody></table>");
    }else{%>
            <div class="container alert alert-primary" role="alert">
                <p class="text-center">No more delivering orders!</p>
            </div>
                <%}%>
    </div>

    <h2 class="display-3 text-center">Completed Orders</h2>
    <%
        ArrayList<Order> completedOrders = (ArrayList<Order>) request.getAttribute("completed");
        if(completedOrders.size() > 0){
    %>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Status</th>
                <th scope="col">Total Price</th>
                <th scope="col">Ordered Time</th>
            </tr>
            </thead>
            <tbody>
                <%
        for(int i = 0; i < completedOrders.size(); i++) {
                out.print("<tr>" +
                    "<td>" + completedOrders.get(i).getId() + "</td>" +
                    "<td>" + completedOrders.get(i).getCusid() + "</td>" +
                    "<td>" + completedOrders.get(i).getName() + "</td>" +
                    "<td>" + completedOrders.get(i).getQuality() + "</td>" +
                    "<td>" + completedOrders.get(i).getStatus() + "</td>" +
                    "<td>" + completedOrders.get(i).getTprice() + "</td>" +
                    "<td>" + completedOrders.get(i).getOrderedtime() + "</td>" +
                    "</tr>");
        }
        out.print("</tbody></table>");
    }else{%>
            <div class="container alert alert-primary" role="alert">
                <p class="text-center">No more completed orders!</p>
            </div>
                <%}%>
    </div>
</body>
</html>
