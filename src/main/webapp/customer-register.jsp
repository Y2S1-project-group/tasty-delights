<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Sign Up</h2>


                            <form action="CustomerCreateAccount" method="post" name="create-account-form" onsubmit="return validateForm()">
                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text" name="fname" id="fname" placeholder="Enter first name"><br>
                                    <p class = "error-message" id="error-fname"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text" name="lname" id="lname" placeholder="Enter last name"><br>
                                    <p class = "error-message" id="error-lname"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text"  name="age" id="age" placeholder="Enter age"><br>
                                    <p class = "error-message" id="error-age"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text"  name="email" id="email" placeholder="Enter email"><br>
                                    <p class = "error-message" id="error-email"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text" name="contact" id="contact" placeholder="Enter contact number"><br>
                                    <p class = "error-message" id="error-contact"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="text" name="address" id="address" placeholder="Enter address"><br>
                                    <p class = "error-message" id="error-address"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="password" name="password" id="password" placeholder="Enter password"><br>
                                    <p class = "error-message" id="error-password"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input class="form-control form-control-lg" type="password" name="confirm-password" id="confirm-password" placeholder="Re enter password"><br>
                                    <p class = "error-message" id="error-confirm-password"></p>
                                    <p class = "error-message" id="error-pass-mismatch"></p>
                                </div>
                                <div class="row">
                                    <div class="col-12 text-left">
                                        <input type="checkbox" onclick="showHidePassword()"> Show Password
                                    </div>
                                </div>
                                <div>
                                    <input class="btn btn-primary btn-lg px-5" type="submit" value="Register">
                                </div>
                            </form>
                            <p ><a class="" href="./customer-reset-password.jsp">Forgot password?</a></p>
                            <a href="./customer-login.jsp" class="fw-bold">Go back to login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="scripts/customer-register.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
