<%@ page import="com.model.DeliveryPerson" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/26/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee- Assign Delivery Person</title>
</head>
<body>
<%
    String orderId = request.getParameter("id");
%>
<form action="ManageOrderAssignDeliveryPersonRedirect" method="get">
    <input type="text" value="<%out.print(orderId);%>" name="orderId" hidden>
    <select name="did">
        <option selected disabled>Select Delivery Person</option>
<%
  ArrayList<DeliveryPerson> persons = (ArrayList<DeliveryPerson>) request.getAttribute("deliveryPersons");
  for(int i = 0; i < persons.size(); i++) {
      out.print("<option value='"+ persons.get(i).getId() +"'>" + persons.get(i).getName() + "</option>");
  }
%>
    </select>
    <input type="submit" value="Assign">
</form>
</body>
</html>
