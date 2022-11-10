function validateForm(){
    let email = document.forms["reset-form"]["email"].value;
    let newPassword = document.forms["reset-form"]["new-password"].value;
    let reNewPassword = document.forms["reset-form"]["re-new-password"].value;

    let userEmail = document.getElementById("email");
    let userPassword = document.getElementById("new-password");
    let userRePassword = document.getElementById("re-new-password");

    let errorEmail = document.getElementById("error-email");
    let errorPassword = document.getElementById("error-password");
    let errorRePassword = document.getElementById("error-re-password");
    let errorMismatch = document.getElementById("error-pass-mismatch");

    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let error = false;

    if(email.length === 0){
        errorEmail.innerHTML = "Enter Email!";
        userEmail.style.border = "1px solid red";
        errorEmail.style.color = "red";
        error = true;
    }else if(!String(email).toLocaleLowerCase().match(re)){
        errorEmail.innerHTML = "Invalid Email!";
        userEmail.style.border = "1px solid red";
        errorEmail.style.color = "red";
        error = true;
    }else{
        errorEmail.innerHTML = "";
        userEmail.style.border = "1px solid green";
        errorEmail.style.color = "";
    }

    if(newPassword.length == 0){
        errorPassword.innerHTML = "Enter Password!";
        userPassword.style.border = "1px solid red";
        errorPassword.style.color = "red";
        error = true;
    }else if(newPassword.length > 0 && newPassword.length < 8){
        errorPassword.innerHTML = "Password Should Be Minimum 8 Characters!";
        userPassword.style.border = "1px solid red";
        errorPassword.style.color = "red";
        error = true;
    } else{
        errorPassword.innerHTML = "";
        userPassword.style.border = "1px solid green";
        errorPassword.style.color = "";
    }

    if(reNewPassword.length == 0){
        errorRePassword.innerHTML = "Enter Password!";
        userRePassword.style.border = "1px solid red";
        errorRePassword.style.color = "red";
        error = true;
    }else if(reNewPassword.length > 0 && reNewPassword.length < 8){
        errorRePassword.innerHTML = "Password Should Be Minimum 8 Characters!";
        userRePassword.style.border = "1px solid red";
        errorRePassword.style.color = "red";
        error = true;
    } else{
        errorRePassword.innerHTML = "";
        userRePassword.style.border = "1px solid green";
        errorRePassword.style.color = "";
    }

    if(error){
        return false;
    }
}