<%@ page import="com.model.DeliveryPerson" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/26/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<%@include file="./employee-manage-orders-header.jsp" %>
<html>
<head>
    <title>Employee- Assign Delivery Person</title>
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
<%
    ArrayList<DeliveryPerson> persons = (ArrayList<DeliveryPerson>) request.getAttribute("deliveryPersons");
    String orderId = request.getParameter("id");
%>
<div class="container">
    <form name="assign-form" action="ManageOrderAssignDeliveryPersonRedirect" method="get" class="form-control" onsubmit="return validateForm();">
        <div class="mb-3">
            <input type="text" value="<%out.print(orderId);%>" name="orderId" hidden>
            <p id='error-select'></p>
            <select class="form-select" name="did" required>
                <option value="default" selected disabled>Select Delivery Person</option>
                <%
                    for(int i = 0; i < persons.size(); i++) {
                        out.print("<option value='"+ persons.get(i).getId() +"'>" + persons.get(i).getName() + "</option>");
                    }
                %>
            </select>
        </div>
        <input class="btn btn-success" type="submit" value="Assign">
    </form>
</div>
<script src="scripts/employee-order-assign.js"></script>
</body>
</html>
