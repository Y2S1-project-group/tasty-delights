<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/22/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee- Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        .container{
            margin-top: 150px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card form-holder">
                    <div class="card-body">
                        <div class="col col-12">
                            <p class="alert alert-danger text-center">Invalid Loggin Credentials!</p>
                        </div>
                        <form action="EmployeeLogin" method="POST">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" name="username" class="form-control" placeholder="Enter username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
                            </div>
                            <div class="row">
                                <div class="col-12 text-left">
                                    <input type="checkbox" onclick="showHidePassword()"> Show Password
                                </div>
                            </div>
                            <div class="row">
                                <div class="login col-12 text-center">
                                    <input type="submit" class="btn btn-primary" value=" Login " />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="./scripts/employee-login.js"></script>
</body>
</html>
