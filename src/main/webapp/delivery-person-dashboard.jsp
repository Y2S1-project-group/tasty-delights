<%@ page import="com.model.DeliveryOrder" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 11/10/2022
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./delivery-person-header.jsp" %>
<html>
<head>
    <title>Delivery Person Dashboard</title>
</head>
<body>
<%
    // HTTP 1.1
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    // HTTP 1.0
    response.setHeader("Pragma", "no-cache");
    // Proxies
    response.setHeader("Expires", "0");
//    if (session.getAttribute("username") == null) {
//        response.sendRedirect("./employee.jsp");
//    }
%>
<h2 class="display-3 text-center">Delivering Orders</h2>
<%
    ArrayList<DeliveryOrder> deliveryOrders = (ArrayList<DeliveryOrder>) request.getAttribute("deliveryOrders");
    if(deliveryOrders.size() > 0){
%>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Order ID</th>
                <th scope="col">Delivery Person ID</th>
                <th scope="col">Status</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <%
                 for(int i = 0; i < deliveryOrders.size(); i++){
                     out.print("<tr>" +
                            "<td>" + deliveryOrders.get(i).getId() + "</td>" +
                            "<td>" + deliveryOrders.get(i).getOrderId() + "</td>" +
                            "<td>" + deliveryOrders.get(i).getDeliveryPersonId() + "</td>" +
                            "<td>" + deliveryOrders.get(i).getStatus() + "</td>" +
                            "<td><a class='btn btn-success' href='DeliveryOrdersStatusUpdate?orderId=" + deliveryOrders.get(i).getOrderId() + "&id=" + deliveryOrders.get(i).getId() + "'>Order Completed</a></td>" +
                            "</tr>");
                 }
                out.print("</tbody></table>");
    }else{%>
            <div class="container alert alert-primary" role="alert">
                <p class="text-center">No more delivering orders!</p>
            </div>
                <%}%>
    </div>
</body>
</html>
