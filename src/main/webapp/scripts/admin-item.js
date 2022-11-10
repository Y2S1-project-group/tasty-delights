function validateForm(){
    let name  = document.forms["create-item"]["item-name"].value;
    let price = document.forms["create-item"]["item-price"].value;
    let image = document.forms["create-item"]["item-image"].value;

    let messageName = document.getElementById("error-name");
    let messageImage = document.getElementById("error-image");
    let messagePrice = document.getElementById("error-price");

    let error = false;

    if(name.length === 0){
        messageName.innerHTML = "Enter item name!";
        messageName.style.color = "red";
        error = true;
    }

    if(image.length === 0){
        messageImage.innerHTML = "Enter item quantity!";
        messageImage.style.color = "red";
        error = true;
    }

    if(price.length === 0){
        messagePrice.innerHTML = "Enter item price!";
        messagePrice.style.color = "red";
        error = true;
    }

    if(parseFloat(price) <= 0){
        messagePrice.innerHTML = "Price should be more than zero!";
        messagePrice.style.color = "red";
        error = true;
    }

    if(error){
        //prevent default form submission
        return false;
    }
}