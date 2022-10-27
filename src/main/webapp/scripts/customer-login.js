function validateForm(){
    let email = document.forms["login-form"]["email"].value;
    let password = document.forms["login-form"]["password"].value;
    let messagePass = document.getElementById("error-pass");
    let messageEmail = document.getElementById("error-email");

    console.log(email)
    console.log(password)
    console.log(messagePass)
    console.log(messageEmail)

    // https://stackoverflow.com/questions/65801147/validate-email-pattern-with-regex
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    let loginPass = document.getElementById("login-password");
    let loginEmail = document.getElementById("login-email");
    let error = false;

    // validation of email
    if(email.length == 0){
        messageEmail.innerHTML = "Enter Email!";
        loginEmail.style.border = "1px solid red";
        messageEmail.style.color = "red";
        error = true;
    }else if(!String(email).toLocaleLowerCase().match(re)){
        messageEmail.innerHTML = "Invalid Email!";
        loginEmail.style.border = "1px solid red";
        messageEmail.style.color = "red";
        error = true;
    }else{
        messageEmail.innerHTML = "";
        loginEmail.style.border = "1px solid green";
        messageEmail.style.color = "";
    }

    // validation of password
    if(password.length == 0){
        messagePass.innerHTML = "Enter Password!";
        loginPass.style.border = "1px solid red";
        messagePass.style.color = "red";
        error = true;
    }else if(password.length > 0 && password.length < 8){
        messagePass.innerHTML = "Password Should Be Minimum 8 Characters!";
        loginPass.style.border = "1px solid red";
        messagePass.style.color = "red";
        error = true;
    } else{
        messagePass.innerHTML = "";
        loginPass.style.border = "1px solid green";
        messagePass.style.color = "";
    }

    if(error){
        return false;
    }
}