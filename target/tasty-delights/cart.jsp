<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="com.model.cartItem" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: GIHAA
  Date: 10/23/2022
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee- Manage Orders</title>
</head>
<body>
<c:set var="id"
<h1>Manage orders</h1>
<table border="1">
    <tr>
        <th>x</th>
        <th>x</th>
        <th>ID</th>
        <th>cartid</th>
        <th>iName</th>
        <th>quantity</th>
    </tr>
    <tr>
        <%
            ArrayList<cartItem> disCart = (ArrayList<cartItem>) request.getAttribute("cart");
            for(int i = 0; i < disCart.size(); i++) {
                out.println("<form method='post' action='deleteCartItem'>");
                    out.print("<tr>" +
                        "<td>" + "<input type ='hidden' name='id' value='"+disCart.get(i).getId()+ "'/>" + "</td>" +
                        "<td>" + "<input type ='hidden' name='cartid' value='"+disCart.get(i).getCartid()+ "'/>" + "</td>" +
                        "<td>" + disCart.get(i).getId() + "</td>" +
                        "<td>" + disCart.get(i).getCartid() + "</td>" +
                        "<td>" + disCart.get(i).getIname() + "</td>" +
                        "<td>" + disCart.get(i).getQuantity() + "</td>" +
                        "<td>" + "<input type='submit' value='delete'/>" + "</td>" +
                        "</tr>");
                out.println("</form>");
            }
        %>
    </tr>
</table>
</body>
</html>