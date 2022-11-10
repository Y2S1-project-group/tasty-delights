function showHidePassword() {
    const val1 = document.getElementById('password');
    const val2 = document.getElementById('re-password');
    if (val1.type === 'password') {
        val1.type = 'text';
    } else {
        val1.type = 'password';
    }

    if (val2.type === 'password') {
        val2.type = 'text';
    } else {
        val2.type = 'password';

    }
}

function validateForm(){
    const password = document.forms["reset-form"]["password"].value;
    const rePassword = document.forms["reset-form"]["re-password"].value;

    let errorPassword = document.getElementById("error-password");
    let errorRePassword = document.getElementById("error-re-password");
    let errormistmatch = document.getElementById("error-mismatch");

    let error = false;

    if (password.length == 0){
        errorPassword.style.color = 'red';
        errorPassword.innerText = 'Please enter password';
        error = true;
    }else{
        errorPassword.innerText = '';
    }

    if (rePassword.length == 0){
        errorRePassword.style.color = "red";
        errorRePassword.innerText = "Please enter password again";
        error = true;
    }else{
        errorRePassword.innerText = "";
    }

    if(!(rePassword == password)){
        errormistmatch.style.color = "red";
        errormistmatch.innerText = "Please enter same passwords";
        error = true;
    }else{
        errormistmatch.innerText = "";
    }

    if(error){
        return false;
    }
}
