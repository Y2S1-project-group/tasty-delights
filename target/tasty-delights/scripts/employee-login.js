function showHidePassword(){
    const val = document.getElementById('password');
    if (val.type === 'password') {
        val.type = 'text';
    }else{
        val.type = 'password';
    }
}

function validateForm(){
    const username = document.forms["login-form"]["username"].value;
    const password = document.forms["login-form"]["password"].value;
    const errorText = document.getElementById("error-text");
    const errorBox = document.getElementById("error-box");
    let error = false;

    // validate username
    if (username.length == 0){
        errorBox.style.visibility = "visible";
        errorText.style.color = "red";
        errorText.innerText = "Please enter username";
        error = true;
    }

    // validate password
    if (password.length == 0){
        errorBox.style.visibility = "visible";
        errorText.style.color = "red";
        errorText.innerText = "Please enter password";
        error = true;
    }

    // validate username and password
    if(username.length == 0 && password.length == 0){
        errorBox.style.visibility = "visible";
        errorText.style.color = "red";
        errorText.innerText = "Please enter credentials";
        error = true;
    }

    if(error){
        return false;
    }
}