function validateForm(){
    let itemName = document.forms["update-item"]["name"].value;
    let price = document.forms["update-item"]["price"].value;
    let image = document.forms["update-item"]["item-image"].value;
    let description = document.forms["update-item"]["description"].value;
    let category = document.forms["update-item"]["category"].value;


    let messageName = document.getElementById("error-name");
    let messageImage = document.getElementById("error-image");
    let messagePrice = document.getElementById("error-price");
    let messageDescription = document.getElementById("error-description");
    let messageCategory = document.getElementById("error-category");

    let error = false;

    if(itemName.length == 0){
        messageName.innerHTML = "Enter item name!";
        messageName.style.color = "red";
        error = true;
    }

    if(image.length == 0){
        messageImage.innerHTML = "Enter item quantity!";
        messageImage.style.color = "red";
        error = true;
    }

    if(price.length == 0){
        messagePrice.innerHTML = "Enter item price!";
        messagePrice.style.color = "red";
        error = true;
    }

    if(description.length == 0){
        messageDescription.innerHTML = "Enter item description!";
        messageDescription.style.color = "red";
        error = true;
    }

    if(category.length == 0){
        messageCategory.innerHTML = "Enter item category!";
        messageCategory.style.color = "red";
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