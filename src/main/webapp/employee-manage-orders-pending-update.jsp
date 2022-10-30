<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form action="ManageOrderUpdateRedirect" method="get">

<%
    ArrayList<Order> order = (ArrayList<Order>) request.getAttribute("orders");
    out.print(
            "<input name='id' type='text' value='"+ order.get(0).getId() +"' hidden><br>" +
            "Name: <input name='itemname' type='text' value='"+ order.get(0).getName() +"'><br>" +
                    "Quantity: <input name='quantity' type='text' value='"+ order.get(0).getQuality() +"'><br>" +
                    "Price: <input name='price' type='text' value='"+ order.get(0).getTprice() + "'><br>" +
            "<input  type='submit' value='Update'>"
    );
%>
    </form>
    <a href="ManageOrdersPending">Cancel</a>
</body>
</html>
