<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Item" %>
<%@ page import="com.model.Cart" %>
<%@ page import="com.util.ItemDatabaseUtil" %>
<%@ page import="com.util.CartDatabaseUtil" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Home - Brand</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700&amp;display=swap">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script&amp;display=swap">
  <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
</head>

<body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
  <div class="container"><a class="navbar-brand" href="#page-top">Tasty Delights</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto text-uppercase">
        <li class="nav-item"><a class="nav-link" href="index.jsp"><- go back</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <table class="table">
    <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Status</th>
      <th scope="col">Total Price</th>
      <th scope="col">Ordered Time</th>
      <th scope="col">Process</th>
    </tr>
    </thead>
    <tbody>
      <%

            for(int i = 0; i < orders.size(); i++) {
                if(orders.get(i).getStatus().equals("pending")){
                    out.print("<tr>" +
                            "<td>" + orders.get(i).getId() + "</td>" +
                            "<td>" + orders.get(i).getCusid() + "</td>" +
                            "<td>" + orders.get(i).getName() + "</td>" +
                            "<td>" + orders.get(i).getQuality() + "</td>" +
                            "<td>" + orders.get(i).getStatus() + "</td>" +
                            "<td>" + orders.get(i).getTprice() + "</td>" +
                            "<td>" + orders.get(i).getOrderedtime() + "</td>" +
                            "<td>" +
                                "<a class='mBtn btn btn-success' href='ManageOrderPrepare?id=" + orders.get(i).getId() + "'>Prepare</a>" +
                                "<a class='mBtn btn btn-warning' href='ManageOrderUpdate?id=" + orders.get(i).getId() + "'>Update</a>" +
                                "<a class='mBtn btn btn-danger'href='ManageOrderDelete?id=" + orders.get(i).getId() + "'>Delete</a>" +
                            "</td>" +
                            "</tr>");
                }
            }
            out.print("</tbody></table>");
    }else{ %>
    <div class="container alert alert-primary" role="alert">
      <p class="text-center">No more pending orders!</p>
    </div>
      <% } %>
</div>
<%
  try {
  String status = (String) request.getAttribute("prepareStatus");
  if(!status.equals(null)){
  if(status.equalsIgnoreCase("success")){
%>
<script>
  swal({
    title: "Order is preparing!",
    icon: "success",
    button: "Ok",
  });
</script>
<%
  }else{
%>
<script>
  swal({
    title: "Order is not preparing!",
    icon: "error",
    button: "Ok",
  });
</script>
<%
  }
  }
  request.removeAttribute("prepareStatus");
  }catch (Exception e){
  e.printStackTrace();
  }
%>
<%
  try {
  String status = (String) request.getAttribute("updateStatus");
  if(!status.equals(null)){
  if(status.equalsIgnoreCase("success")){
%>
<script>
  swal({
    title: "Order is updated!",
    icon: "success",
    button: "Ok",
  });
</script>
<%
  }else{
%>
<script>
  swal({
    title: "Order is not updated!",
    icon: "error",
    button: "Ok",
  });
</script>
<%
  }
  }
  request.removeAttribute("updateStatus");
  }catch (Exception e){
  e.printStackTrace();
  }
%>
<%
  try {
  String status = (String) request.getAttribute("deleteStatus");
  if(!status.equals(null)){
  if(status.equalsIgnoreCase("success")){
%>
<script>
  swal({
    title: "Order is deleted!",
    icon: "success",
    button: "Ok",
  });
</script>
<%
  }else{
%>
<script>
  swal({
    title: "Order is not deleted!",
    icon: "error",
    button: "Ok",
  });
</script>
<%
  }
  }
  request.removeAttribute("deleteStatus");
  }catch (Exception e){
  e.printStackTrace();
  }
%>
</body>

<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-4"><span class="copyright">Copyright&nbsp;© Brand 2022</span></div>
      <div class="col-md-4">
      </div>
      <div class="col-md-4">
        <ul class="list-inline quicklinks">
          <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
          <li class="list-inline-item"><a href="#">Terms of Use</a></li>
        </ul>
      </div>
    </div>
  </div>
</footer>
</body>
</html>
