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

<script src="scripts/admin-item.js"></script>

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
    <form name="create-item" onsubmit="return validateForm();" action="ItemsCreate" method="get">
<%
    out.print(
            "<div>" +
                "<label>Name:</label></br>" +
                "<input id='create-name' class='item-create-form' name='item-name' type='text' value=''>" +
                "<p id='error-name'></p>" +
            "</div>" +
            "<div>" +
                "<label>Age:</label></br>" +
                "<input id='create-price' class='item-create-form' name='item-age' type='text' value=''>" +
                "<p id='error-price'></p>" +
            "</div>" +
            "<div>" +
                "<label>Contact:</label></br>" +
                "<input id='create-image' class='item-create-form' name='item-contact' type='text' value=''>" +
                "<p id='error-image'></p>" +
            "</div>" +
            "<div>" +
                "<label>Email:</label></br>" +
                "<input id='create-image' class='item-create-form' name='item-email' type='text' value=''>" +
                "<p id='error-image'></p>" +
            "</div>" +
            "<div>" +
                "<label>Username:</label></br>" +
                "<input id='create-image' class='item-create-form' name='item-username' type='text' value=''>" +
                "<p id='error-image'></p>" +
            "</div>" +
            "<div>" +
                "<label>Password:</label></br>" +
                "<input id='create-image' class='item-create-form' name='item-password' type='text' value=''>" +
                "<p id='error-image'></p>" +
            "</div>" +
                "<input type='submit' class='item-button create-item-button' value='Create Item'></form> " +
            "</div>"
    );
%>
    </form>
    <div class="cancel-create-form">
        <a class="text-center" href="DeliveryGet">Cancel</a>
    </div>
</div>

</body>
</html>

