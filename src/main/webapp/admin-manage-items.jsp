<%@ page import="com.model.Item" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Pasindu Dinal
  Date: 11/1/2022
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./employee-header.jsp" %>
<html>
<head>
    <title>Food Items</title>
    <link rel="stylesheet" href="styles/button.css">
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
<div class="top-bar">
    <h6 class="item-title">Food Items</h6>

    <form action="ItemsSearch" method="get">
        <input type="text" name="searchQuery" placeholder="Search..." class="search-form">
        <input type="submit" value="Search" class="item-button">
    </form>

    <div>
        <a href = "admin-manage-items-create.jsp" class="add-new-link">Add New Food Item</a>
        <div class="circle">
            +
        </div>
    </div>
</div>
<%
    ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
    if(items.size() > 0){

%>


<div class="container h-center">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">📷</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">📝</th>
        </tr>
        </thead>
        <tbody>
            <%
            for(int i = 0; i < items.size(); i++) {
                    out.print("<tr>" +
                            "<td>" + "<img src = 'assets/"+ items.get(i).getImage()+"'width='50' height='50'>" + "</td>" +
                            "<td>" + items.get(i).getName() + "</td>" +
                            "<td>" + items.get(i).getPrice() + "</td>" +
                            "<td>" +
                                "<a class='mBtn btn btn-warning' href='ItemsUpdate?id=" + items.get(i).getId() + "'>Update</a>" +
                                "<a class='mBtn btn btn-danger'href='ItemsDelete?id=" + items.get(i).getId() + "'>Delete</a>" +
                            "</td>" +
                            "</tr>");
            }
            out.print("</tbody></table>");
    }else{ %>
        <div class="container alert alert-primary" role="alert">
            <p class="text-center">No Items!</p>
        </div>
            <% } %>
</div>


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
</html>
