function validateForm(){
    let itemName = document.forms["update-name"]["item-name"].value;
    let quantity = document.forms["update-name"]["quantity"].value;
    let price = document.forms["update-name"]["price"].value;

    let messageItemName = document.getElementById("error-name");
    let messageQuantity = document.getElementById("error-quantity");
    let messagePrice = document.getElementById("error-price");

    let updateName = document.getElementById("update-name");
    let updateQuantity = document.getElementById("update-quantity");
    let updatePrice = document.getElementById("update-price");

    let error = false;

    if(itemName.length == 0){
        messageItemName.innerHTML = "Enter item name!";
        messageItemName.style.color = "red";
        error = true;
    }else{
        messageItemName.innerHTML = "";
        messageItemName.style.color = "";
    }

    if(quantity.length == 0){
        messageQuantity.innerHTML = "Enter item quantity!";
        messageQuantity.style.color = "red";
        error = true;
    }else{
        messageQuantity.innerHTML = "";
        messageQuantity.style.color = "";
    }

    if(price.length == 0){
        messagePrice.innerHTML = "Enter item price!";
        messagePrice.style.color = "red";
        error = true;
    }else{
        messagePrice.innerHTML = "";
        messagePrice.style.color = "";
    }

    if(error){
        return false;
    }
}