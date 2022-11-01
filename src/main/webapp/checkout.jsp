<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="com.model.cartItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.cartDao" %>
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
    <%
      cartDao cart = new cartDao();
      int total = 0;

      ArrayList<cartItem> disCart =  cart.displayCart(cart.getCartId(1)); // session
      for(int i = 0; i < disCart.size(); i++) {
        total += (disCart.get(i).getPrice() * disCart.get(i).getQuantity());
      }
      out.println("total is :" + total);

      out.println("<form method='post' action='checkout-completed'>");
        out.print("<tr>" +
            "<td>" + "<input type ='hidden' name='cus' value='"+1 /*session*/+ "'/>" + "</td>" +
                "<td>" + "<input type ='hidden' name='total' value='"+ total + "'/>" + "</td>" +
        "<td>"+ "<input type='submit' value='min'/>" + "</td>" +
        "</tr>");
      out.println("</form>");

    %>

  </tr>
</table>

<a href="order-placed.jsp">
  <input type="button" name="back" value="play now">
</a>


</body>
</html>