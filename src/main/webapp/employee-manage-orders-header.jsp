<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Manage orders</h1>

<form action="ManageOrders">
  <input type="submit" value="All Orders">
</form>
<form action="ManageOrdersPending" method="get">
  <input type="submit" value="Pending Orders">
</form>
<form action="ManageOrdersPreparing" method="get">
  <input type="submit" value="Preparing Orders">
</form>
<form action="ManageOrdersDelivering" method="get">
  <input type="submit" value="Delivering Orders">
</form>
<form action="ManageOrdersCompleted" method="get">
  <input type="submit" value="Completed Orders">
</form>
