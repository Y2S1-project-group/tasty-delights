<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="com.model.CartItem" %>
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

<h1>Manage orders</h1>

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
            ArrayList<CartItem> disCart = (ArrayList<CartItem>) request.getAttribute("cart");
            for(int i = 0; i < disCart.size(); i++) {
                out.println("<form method='post' action='DeleteCartItem'>");
                    out.print("<tr>" +
                        "<td>" + "<input type ='hidden' name='id' value='"+disCart.get(i).getId()+ "'/>" + "</td>" +
                        "<td>" + "<input type ='hidden' name='cartid' value='"+disCart.get(i).getCartid()+ "'/>" + "</td>" +
                        "<td>" + disCart.get(i).getId() + "</td>" +
                        "<td>" + disCart.get(i).getCartid() + "</td>" +
                        "<td>" + disCart.get(i).getIname() + "</td>" +
                        "<td>" + disCart.get(i).getQuantity() + "</td>" +
                        "<td>" + disCart.get(i).getPrice() + "</td>" +
                        "<td>" + "<input type='submit' value='delete'/>" + "</td>" +
                        "</tr>");
                out.println("</form>");

                out.println("<form method='post' action='PlusCartItemQuantity'>");
                        out.print("<tr>" +
                        "<td>" + "<input type ='hidden' name='id' value='"+disCart.get(i).getId()+ "'/>" + "</td>" +
                        "<td>" + "<input type ='hidden' name='cartid' value='"+disCart.get(i).getCartid()+ "'/>" + "</td>" +
                        "<td>"+ "<input type='submit' value='plus'/>" + "</td>" +
                        "</tr>");
                out.println("</form>");

                out.println("<form method='post' action='MinusCartItemQuantity'>");
                    out.print("<tr>" +
                        "<td>" + "<input type ='hidden' name='id' value='"+disCart.get(i).getId()+ "'/>" + "</td>" +
                        "<td>" + "<input type ='hidden' name='cartid' value='"+disCart.get(i).getCartid()+ "'/>" + "</td>" +
                    "<td>"+ "<input type='submit' value='min'/>" + "</td>" +
                    "</tr>");
                out.println("</form>");
            }
        %>



    </tr>
</table>
<a href="index.jsp">
    <input type="button" name="back" value="back">
</a>
<a href="checkout.jsp">
    <input type="button" name="back" value="checkout">
</a>


</body>
</html>