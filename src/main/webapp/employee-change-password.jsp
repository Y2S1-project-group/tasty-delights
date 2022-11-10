<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/23/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
  <title>Orders- Pending Orders</title>
  <link rel="stylesheet" href="styles/button.css">
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
<h2 class="display-3 text-center">Change Password</h2>
<div class="container">
  <form name="reset-form" onsubmit="return validateForm();" action="EmployeeChangePassword" method="POST">
    <div class="form-group">
      <input class="form-control" type="password" name="password" id="password" placeholder="Enter new password">
      <p class = "error-message" id="error-password"></p>
    </div>
    <div class="form-group">
      <input class="form-control" type="password" name="re-password" id="re-password" placeholder="Enter new password again">
      <p class = "error-message" id="error-re-password"></p>
      <p class = "error-message" id="error-mismatch"></p>
    </div>
    <div class="row">
      <div class="col-12 text-left">
        <input type="checkbox" onclick="showHidePassword()"> Show Password
      </div>
    </div>
    <div class="row">
      <div class="login col-12 text-center">
        <input type="submit" class="btn btn-danger float-sm-left" value="Change Password" />
      </div>
    </div>
  </form>
</div>


<%
  try {
    String prepareStatus = (String) request.getAttribute("resetPasswordStatus");
    if(!prepareStatus.equals(null)){
      if(prepareStatus.equalsIgnoreCase("success")){
%>
<script>
  swal({
    title: "Password is changed!",
    icon: "success",
    button: "Ok",
  });
</script>
<%
}else{
%>
<script>
  swal({
    title: "Password is not changed!",
    icon: "error",
    button: "Ok",
  });
</script>
<%
      }
    }
    request.removeAttribute("resetPasswordStatus");
  }catch (Exception e){
    e.printStackTrace();
  }
%>


<script src="scripts/employee-change-password.js"></script>
</body>
</html>
