<%@ page import="com.model.Item" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Pasindu Dinal
  Date: 11/01/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
    <title>Create Item</title>
    <link rel="stylesheet" href="styles/item.css">
</head>
<body>
<%
    // HTTP 1.1
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    // HTTP 1.0
    response.setHeader("Pragma", "no-cache");
    // Proxies
    response.setHeader("Expires", "0");
    //if (session.getAttribute("username") == null) {
    //    response.sendRedirect("./employee.jsp");
    //}
%>
<div class="create-form">
    <form name="create-item"  action="ItemsCreate" method="get" onsubmit="return validateForm();">
<%
    out.print(
            "<div>" +
                    "<label>Name:</label></br>" +
                    "<input id='update-name' class='item-create-form' name='item-name' type='text' value=''>" +
                    "</div>" +
                    "<div>" +
                        "<p id='error-quantity'></p>" +
                        "<label>Quantity:</label></br>" +
                        "<input id='update-quantity' class='item-create-form' name='quantity' type='text' value=''>" +
                    "</div>" +
                    "<div>" +
                        "<p id='error-price'></p>" +
                        "<label>Price:</label></br>" +
                        "<input id='update-price' class='item-create-form' name='price' type='text' value=''>" +
                    "</div>" +
                    "<div>" +
                    "<label>Image Name:</label></br>" +
                    "<input id='update-ne' class='item-create-form' name='image' type='text' value=''>" +
                    "</div>" +
                        "<input type='submit' class='item-button' value='Update'></form> " +
            "</div>"
    );
%>
    </form>
    <div class="container">
        <a class="text-center" href="ItemsGet">Cancel</a>
    </div>
</div>
<script src="scripts/employee-order-update.js"></script>
</body>
</html>


