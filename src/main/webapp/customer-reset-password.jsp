<%--
  Created by IntelliJ IDEA.
  User: Sapumal Wijekoon
  Date: 10/27/2022
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<html>
<head>
    <title>Reset Password</title>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Forgot Password</h2>

              <form action="CustomerPasswordReset" method="post" name="reset-form" onsubmit="return validateForm()">
                <div class="form-outline mb-4">
                  <input class="form-control form-control-lg" id="email" name="email" type="text" placeholder="Enter email"><br>
                  <p class = "error-message" id="error-email"></p>
                </div>
                <div class="form-outline mb-4">
                  <input  class="form-control form-control-lg" id="new-password" name="new-password" type="password" placeholder="Enter new password"><br>
                  <p class = "error-message" id="error-password"></p>
                </div>
                <div class="form-outline mb-4">
                  <input class="form-control form-control-lg" id="re-new-password" name="re-new-password" type="password" placeholder="Re enter new password"><br>
                  <p class = "error-message" id="error-re-password"></p>
                  <p class = "error-message" id="error-mismatch-password"></p>
                </div>
                <input class="btn btn-primary btn-lg px-5" type="submit" name="forgot" value="Reset Password">
              </form>
              <a href="./customer-login.jsp" class="fw-bold">Go back</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



  <%
    try {
      String status = (String) request.getAttribute("resetStatus");
      out.print(status);
      if(!status.equals(null)){
        if(status.equalsIgnoreCase("pass")){
  %>
  <script>
    alert("success")
    swal({
      title: "Password reset success!",
      icon: "success",
      button: "Ok",
    });
  </script>
  <%
  }else{
  %>
  <script>
    alert("fail")
    swal({
      title: "Password not reset!",
      icon: "error",
      button: "Ok",
    });
  </script>
  <%
        }
      }
      request.removeAttribute("resetStatus");
    }catch (Exception e){
      e.printStackTrace();
    }
  %>

<script src="scripts/customer-password-reset.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
