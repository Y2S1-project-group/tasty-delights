function validateForm(){
    let assignment = document.forms["assign-form"]["did"].value;
    let errorAssignment = document.getElementById("error-select");
    let error = false;
    
    if(assignment === 'default'){
        errorAssignment.innerHTML = "Select a delivery person!";
        errorAssignment.style.color = "red";
        error = true;
    }else{
        errorAssignment.innerHTML = "";
        errorAssignment.style.color = "";
    }

    if(error){
        return false;
    }
}
