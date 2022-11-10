<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<script>
    function showHidePassword(){
        const val = document.getElementById('login-password');
        if (val.type === 'password') {
            val.type = 'text';
        }else{
            val.type = 'password';
        }
    }
</script>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>

                            <form name="login-form" action="deliveryPersonLogin" method="post" onsubmit="">
                                <p class="mb-2 error-message login-invalid" id="error-login">Invalid login credentials!</p>

                                <div class="form-outline mb-4">
                                    <input name = "email" id="login-email" type="text" class="form-control form-control-lg" placeholder="Enter email"/>
                                    <p class="mb-2 error-message" id="error-email"></p>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name = "password" id = "login-password" type="password" class="form-control form-control-lg" placeholder="Enter password"/>
                                    <p class="mb-2 error-message" id="error-pass"></p>
                                </div>
                                <div class="form-outline mb-4">
                                    <div class="col-12 text-left">
                                        <input type="checkbox" onclick="showHidePassword()"> Show Password
                                    </div>
                                </div>
                                <div>
                                    <input class="btn btn-primary btn-lg px-5" type="submit" value="Login">
                                </div>
                            </form>


                        </div>



                        <div>
                            <a href="./index.jsp" class="fw-bold">Go back</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="scripts/customer-login.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
