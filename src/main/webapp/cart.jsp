<!-- <%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="com.model.CartItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Cart" %>
<%@ page import="com.util.CartDatabaseUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: GIHAA
  Date: 10/23/2022
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.reflowhq.com/v2/toolkit.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <style>
        body{
            background: #ddd;
            min-height: 100vh;
            vertical-align: middle;
            display: flex;
            font-family: sans-serif;
            font-size: 0.8rem;
            font-weight: bold;
        }
        .title{
            margin-bottom: 5vh;
        }
        .card{
            margin: auto;
            max-width: 950px;
            width: 90%;
            box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 1rem;
            border: transparent;
        }
        @media(max-width:767px){
            .card{
                margin: 3vh auto;
            }
        }
        .cart{
            background-color: #fff;
            padding: 4vh 5vh;
            border-bottom-left-radius: 1rem;
            border-top-left-radius: 1rem;
        }
        @media(max-width:767px){
            .cart{
                padding: 4vh;
                border-bottom-left-radius: unset;
                border-top-right-radius: 1rem;
            }
        }
        .summary{
            background-color: #ddd;
            border-top-right-radius: 1rem;
            border-bottom-right-radius: 1rem;
            padding: 4vh;
            color: rgb(65, 65, 65);
        }
        @media(max-width:767px){
            .summary{
                border-top-right-radius: unset;
                border-bottom-left-radius: 1rem;
            }
        }
        .summary .col-2{
            padding: 0;
        }
        .summary .col-10
        {
            padding: 0;
        }.row{
             margin: 0;
         }
        .title b{
            font-size: 1.5rem;
        }
        .main{
            margin: 0;
            padding: 2vh 0;
            width: 100%;
        }
        .col-2, .col{
            padding: 0 1vh;
        }
        a{
            padding: 0 1vh;
        }
        .close{
            margin-left: auto;
            font-size: 0.7rem;
        }
        img{
            width: 3.5rem;
        }
        .back-to-shop{
            margin-top: 4.5rem;
        }
        h5{
            margin-top: 4vh;
        }
        hr{
            margin-top: 1.25rem;
        }
        form{
            padding: 2vh 0;
        }
        select{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1.5vh 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input:focus::-webkit-input-placeholder
        {
            color:transparent;
        }
        .btn{
            background-color: #000;
            border-color: #000;
            color: white;
            width: 100%;
            font-size: 0.7rem;
            margin-top: 4vh;
            padding: 1vh;
            border-radius: 0;
        }
        .btn:focus{
            box-shadow: none;
            outline: none;
            box-shadow: none;
            color: white;
            -webkit-box-shadow: none;
            -webkit-user-select: none;
            transition: none;
        }
        .btn:hover{
            color: white;
        }
        a{
            color: black;
        }
        a:hover{
            color: black;
            text-decoration: none;
        }
        #code{
            background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253) , rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
            background-repeat: no-repeat;
            background-position-x: 95%;
            background-position-y: center;
        }
    </style>

</head>

<body>

<div class="card">
    <div class="row">
        <div class="col-md-8 cart">
            <div class="title">
                <div class="row">
                    <div class="col"><h4><b>Shopping Cart</b></h4></div>
                    <%
                        CartDatabaseUtil newCart = new CartDatabaseUtil(); // sesssion
                        ArrayList<CartItem> disCart = newCart.displayCart(1);// sesssion
                        out.println("<div class='col align-self-center text-right text-muted'>" + disCart.size() + "items</div>");
                    %>
                </div>
            </div>
        <%
            float tprice = 0;

            for(int i = 0; i < disCart.size(); i++) {
                out.println("<div class='row border-top border-bottom'>"
                        + "<div class='row main align-items-center'>"
                        + "<div class='col'>"
                        + "<div class='row'>"+disCart.get(i).getIname()+"</div>"
                        + "</div>"
                        + "<div class='col'>"
                        + "<a href='"+request.getContextPath()+"/MinusCartItemQuantity?id="+disCart.get(i).getId() + "&cartid="+ disCart.get(i).getCartid()+"'>-</a><a href='#' class='border'>"+disCart.get(i).getQuantity()+"</a><a href='"+request.getContextPath()+"/PlusCartItemQuantity?id="+disCart.get(i).getId() + "&cartid="+ disCart.get(i).getCartid()+"'>+</a>"
                        + "</div>"
                        + "<div class='col'>"+ disCart.get(i).getPrice()*disCart.get(i).getQuantity() +"</div>"
                        + "<a href='"+ request.getContextPath() +"/DeleteCartItem?id=" +disCart.get(i).getId() + "&cartid="+ disCart.get(i).getCartid()+"'>"+"<input style=\"width: 100px;\" type='submit' class='btn btn-dark btn-xs' value='delete'/></a>"
                        + "</div>"
                        + "</div>");
                tprice += disCart.get(i).getPrice()*disCart.get(i).getQuantity();
            }
        %>
            <div class='back-to-shop'><a href='index.jsp'>&leftarrow;<span class="text-muted">Back to shop</span></a></div>
        </div>
        <div class="col-md-4 summary">
            <div><h5><b>Summary</b></h5></div>
            <hr>
            <div class="row">
                <% out.println("<div class='col' style='padding-left:0;'>ITEMS " + disCart.size() + "</div>");
                    out.println("<div class='col text-right'>"+ tprice + "</div>"); %>
            </div>
            <form action='AddOrder' method='post'>
                <p>SHIPPING</p>
                <select>
                    <option class='text-muted'>Standard-Delivery  5.00</option>
                    <option class='text-muted'>Standard-Delivery  10.00</option>
                </select>

            <div class='row' style='border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;'>
                <div class='col'>TOTAL PRICE</div>
                <div class='col text-right'>  137.00</div>
            </div>
                <input type='submit' class='btn' value='CheckOut'>
            </form>
        </div>
    </div>
</div>
</body>
</html>