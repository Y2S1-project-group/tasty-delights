<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<%@include file="./employee-manage-orders-header.jsp" %>
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
<div class="container-sm">
    <form name="update-name" action="ManageOrderUpdateRedirect" method="get" onsubmit="return validateForm();">
<%
    ArrayList<Order> order = (ArrayList<Order>) request.getAttribute("orders");
    out.print(
            "<div class='form-group'>" +
                    "<input class='form-control' name='id' type='text' value='" + order.get(0).getId() + "' hidden>" +
                    "<p id='error-name'></p>" +
                    "Name <input id='update-name' class='form-control' name='itemname' type='text' value='" + order.get(0).getName() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-quantity'></p>" +
                        "Quantity <input id='update-quantity' class='form-control' name='quantity' type='text' value='"+ order.get(0).getQuality() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-price'></p>" +
                        "Price <input id='update-price' class='form-control' name='price' type='text' value='" + order.get(0).getTprice() + "'>" +
                    "</div>" +
                        "<input type='submit' class='btn btn-primary' value='Update'></form> " +
            "</div>"
    );
%>
    </form>
    <div class="container">
        <a class="text-center" href="ManageOrdersPending">Cancel</a>
    </div>
</div>
<script src="scripts/employee-order-update.js"></script>
</body>
</html>


