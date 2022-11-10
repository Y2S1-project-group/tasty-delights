function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function validateForm(){
    // get values from input fields
    let firstName = document.forms["create-account-form"]["fname"].value;
    let lastName = document.forms["create-account-form"]["lname"].value;
    let age = document.forms["create-account-form"]["age"].value;
    let email = document.forms["create-account-form"]["email"].value;
    let phoneNumber = document.forms["create-account-form"]["contact"].value;
    let address = document.forms["create-account-form"]["address"].value;

    // input fields
    let userFName = document.getElementById("fname");
    let userLName = document.getElementById("lname");
    let userAge = document.getElementById("age");
    let userEmail = document.getElementById("email");
    let userPhone = document.getElementById("contact");
    let userAddress = document.getElementById("address");

    // error paragraphs
    let errorFName = document.getElementById("error-fname");
    let errorLName = document.getElementById("error-lname");
    let errorAge = document.getElementById("error-age");
    let errorEmail = document.getElementById("error-email");
    let errorPhone = document.getElementById("error-contact");
    let errorAddress = document.getElementById("error-address");

    // regex for email validation
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let error = false;

    // fname
    if (firstName.length != 0) {
        errorFName.innerHTML = "";
        userFName.style.border = "1px solid green";
        errorFName.style.color = "";
    } else {
        errorFName.innerHTML = "Enter First Name!";
        userFName.style.border = "1px solid red";
        errorFName.style.color = "red";
        error = true;
    }

    // lname
    if (lastName.length != 0) {
        errorLName.innerHTML = "";
        userLName.style.border = "1px solid green";
        errorLName.style.color = "";
    } else {
        errorLName.innerHTML = "Enter Last Name!";
        userLName.style.border = "1px solid red";
        errorLName.style.color = "red";
        error = true;
    }

    // age
    if(age.length == 0){
        errorAge.innerHTML = "Enter age!";
        userAge.style.border = "1px solid red";
        errorAge.style.color = "red";
        error = true;
    } else if(!isNumeric(age)){
        errorAge.innerHTML = "Enter age correctly!";
        userAge.style.border = "1px solid red";
        errorAge.style.color = "red";
        error = true;
    }else{
        errorAge.innerHTML = "";
        userAge.style.border = "1px solid green";
        errorAge.style.color = "";
    }

    // email validation
    if(email.length == 0){
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

    // phone validation
    if(phoneNumber.length == 0){
        errorPhone.innerHTML = "Enter Phone Number!";
        userPhone.style.border = "1px solid red";
        errorPhone.style.color = "red";
        error = true;
    }else if(phoneNumber.length != 10){
        errorPhone.innerHTML = "Invalid Phone Number!";
        userPhone.style.border = "1px solid red";
        errorPhone.style.color = "red";
        error = true;
    }else if(!isNumeric(phoneNumber)){
        errorPhone.innerHTML = "Please Enter Digits Only!";
        userPhone.style.border = "1px solid red";
        errorPhone.style.color = "red";
        error = true;
    }else{
        errorPhone.innerHTML = "";
        userPhone.style.border = "1px solid green";
        errorPhone.style.color = ""
    }

    // address validation
    if (address.length != 0) {
        errorAddress.innerHTML = "";
        userAddress.style.border = "1px solid green";
        errorAddress.style.color = "";
    } else {
        errorAddress.innerHTML = "Enter Last Name!";
        userAddress.style.border = "1px solid red";
        errorAddress.style.color = "red";
        error = true;
    }

    if(address.length == 0){
        errorAddress.innerHTML = "Enter Address!";
        userAddress.style.border = "1px solid red";
        errorAddress.style.color = "red";
        error = true;
    }else{
        errorAddress.innerHTML = "";
        userAddress.style.border = "1px solid green";
        errorAddress.style.color = "";
    }

    if(error){
        return false;
    }
}