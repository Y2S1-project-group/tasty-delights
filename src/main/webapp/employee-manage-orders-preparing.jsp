<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
    <title>Orders- Preparing Orders</title>
</head>
<body>
<%@include file="./employee-manage-orders-header.jsp" %>
<h2>Preparing Orders</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Customer ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Status</th>
        <th>Total Price</th>
        <th>Ordered Time</th>
        <th>Process</th>
    </tr>
    <tr>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
            for(int i = 0; i < orders.size(); i++) {
                out.print("<tr>" +
                        "<td>" + orders.get(i).getId() + "</td>" +
                        "<td>" + orders.get(i).getCusid() + "</td>" +
                        "<td>" + orders.get(i).getName() + "</td>" +
                        "<td>" + orders.get(i).getQuality() + "</td>" +
                        "<td>" + orders.get(i).getStatus() + "</td>" +
                        "<td>" + orders.get(i).getTprice() + "</td>" +
                        "<td>" + orders.get(i).getOrderedtime() + "</td>" +
                        "<td>" +
                            "<a href='#?id=" + orders.get(i).getId() + "'>Assign Delivery Person</a>" +
                        "</td>" +
                        "</tr>");
            }
        %>
    </tr>
</table>
</body>
</html>
