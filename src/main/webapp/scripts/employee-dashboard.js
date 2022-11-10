function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

document.getElementById("total-customers").innerText = getCookie("totalCustomers");
document.getElementById("total-listed-items").innerText = getCookie("totalListedItems");
document.getElementById("total-sales").innerText = "Rs: " + getCookie("totalSales");
document.getElementById("pending-orders-count").innerText = getCookie("pendingOrdersCount");
document.getElementById("preparing-order-count").innerText = getCookie("preparingOrderCount");
document.getElementById("delivering-order-count").innerText = getCookie("deliveringOrderCount");

document.getElementById("time1").innerText = "Last updated time: " + getCookie("currentTime");
document.getElementById("time2").innerText = "Last updated time: " + getCookie("currentTime");
document.getElementById("time3").innerText = "Last updated time: " + getCookie("currentTime");
document.getElementById("time4").innerText = "Last updated time: " + getCookie("currentTime");
document.getElementById("time5").innerText = "Last updated time: " + getCookie("currentTime");
document.getElementById("time6").innerText = "Last updated time: " + getCookie("currentTime");
