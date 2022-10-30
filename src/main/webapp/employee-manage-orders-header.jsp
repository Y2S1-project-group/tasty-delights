<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <link rel="stylesheet" href="styles/button.css">
  <style>
    .sub-header{
      margin-top: 10px;
    }
    .sub-nav{
      margin: 1rem;
    }
    .remove-button{
      color: aliceblue;
    }
  </style>
</head>

<div class="sub-header container-md">
  <ul class="nav nav-pills nav-justified">
    <li class="nav-item">
      <a class="sub-nav nav-link active"><form action="ManageOrdersGet"><input class="remove-button" type="submit" value="All Orders"></form></a>
    </li>
    <li class="nav-item">
      <a class="sub-nav nav-link active"><form action="ManageOrdersPending" method="get"><input class="remove-button" type="submit" value="Pending Orders"></form></a>
    </li>
    <li class="nav-item">
      <a class="sub-nav nav-link active"><form action="ManageOrdersPreparing" method="get"><input class="remove-button" type="submit" value="Preparing Orders"></form></a>
    </li>
    <li class="nav-item">
      <a class="sub-nav nav-link active"><form action="ManageOrdersDelivering" method="get"><input class="remove-button" type="submit" value="Delivering Orders"></form></a>
    </li>
    <li class="nav-item">
      <a class="sub-nav nav-link active"><form action="ManageOrdersCompleted" method="get"><input class="remove-button" type="submit" value="Completed Orders"></form></a>
    </li>
  </ul>
</div>

