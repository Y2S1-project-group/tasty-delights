<%@ page import="com.model.OrderItem" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 11/6/2022
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<%@include file="./employee-manage-orders-header.jsp" %>
<html>
<head>
    <title>Order- Order Items</title>
</head>
<body>
<%
    ArrayList<OrderItem> items = (ArrayList<OrderItem>) request.getAttribute("items");
    if(items.size() > 0){
%>
  <div class="container-sm">
      <table class="table">
          <thead>
          <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
          </tr>
          </thead>
          <tbody>
              <%
            for(int i = 0; i < items.size(); i++) {
                    out.print("<tr>" +
                            "<td>" + items.get(i).getId() + "</td>" +
                            "<td>" + items.get(i).getName() + "</td>" +
                            "<td>" + items.get(i).getQuantity() + "</td>" +
                            "<td>" + items.get(i).getPrice() + "</td>" +
                            "</tr>");
            }
            out.print("</tbody></table>");
    }else{ %>
          <div class="container alert alert-primary" role="alert">
              <p class="text-center">No items in the order!</p>
          </div>
              <% } %>
      <a href="ManageOrdersPending">Go back</a>
  </div>
</body>
</html>
