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
    <title>Update Item</title>
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
<div class="container-sm">
    <form name="update-name" action="ItemsUpdateRedirect" method="get">
<%
    Item item =  (Item) request.getAttribute("items");
    out.print(
            "<div class='form-group'>" +
                    "<input class='form-control' name='id' type='text' value='" + item.getId() + "' hidden>" +
                        "<p id='error-name'></p>" +
                        "Name <input id='update-name' class='form-control' name='item-name' type='text' value='" + item.getName() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-price'></p>" +
                        "Price <input id='update-price' class='form-control' name='price' type='text' value='" + item.getPrice() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-price'></p>" +
                        "Description <input id='update-description' class='form-control' name='description' type='text' value='" + item.getDescription() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-price'></p>" +
                        "Category <input id='update-category' class='form-control' name='category' type='text' value='" + item.getCategory() + "'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<p id='error-image'></p>" +
                        "Image Path <input id='update-image' class='form-control' name='image' type='text' value='" + item.getImage() + "'>" +
                    "</div>" +
                        "<input type='submit' class='btn btn-primary' value='Update'></form> " +
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


