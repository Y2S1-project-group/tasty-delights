<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Item" %>
<%@ page import="com.model.Cart" %>
<%@ page import="com.util.ItemDatabaseUtil" %>
<%@ page import="com.util.CartDatabaseUtil" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
</head>

<body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
    <div class="container"><a class="navbar-brand" href="#page-top">Tasty Delights</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto text-uppercase">
                <li class="nav-item"><a class="nav-link" href="#services">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="#portfolio">Product</a></li>
                <li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
                <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
                <li class="nav-item"><a class="nav-link" href="customer-login.jsp">login</a></li>
            <%--session login / register / logout--%>
            </ul>
        </div>
    </div>
</nav>
<header class="masthead" style="background-image:url('assets/img/header-bg.jpg');">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in"><span>Welcome To Our Restaurants!</span></div>
            <div class="intro-heading text-uppercase"><span>Tasty Delights</span></div><a class="btn btn-primary btn-xl text-uppercase" role="button" href="#portfolio">order now</a>
        </div>
    </div>
</header>
<section id="services">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase section-heading">Services</h2>
                <h3 class="text-muted section-subheading">Lorem ipsum dolor sit amet consectetur</h3>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-md-4"><span class="fa-stack fa-4x"><i class="fa fa-circle fa-stack-2x text-primary"></i><i class="fa fa-thumbs-o-up fa-stack-1x fa-inverse"></i></span>
                <h4 class="section-heading">Service</h4>
                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
            </div>
            <div class="col-md-4"><span class="fa-stack fa-4x"><i class="fa fa-circle fa-stack-2x text-primary"></i><i class="fa fa-truck fa-stack-1x fa-inverse"></i></span>
                <h4 class="section-heading">Service</h4>
                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
            </div>
            <div class="col-md-4"><span class="fa-stack fa-4x"><i class="fa fa-circle fa-stack-2x text-primary"></i><i class="fa fa-user fa-stack-1x fa-inverse"></i></span>
                <h4 class="section-heading">Service</h4>
                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</p>
            </div>
        </div>
    </div>
</section>
<section class="bg-light" id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase section-heading">Products</h2>
                <h3 class="text-muted section-subheading">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">

        <%
            ItemDatabaseUtil itemDoa = new ItemDatabaseUtil();
            ArrayList<Item> homepageitems  = itemDoa.getHomeItems();
            CartDatabaseUtil cartDao = new CartDatabaseUtil();


            for(int i = 0; i < homepageitems.size(); i++) {

            out.println("<div class='col-sm-6 col-md-4 portfolio-item' ><a class='portfolio-link' href = '" + request.getContextPath() + "/AddToCart?cartid=" + cartDao.getCartId(1) /*session*/ + "&iname="+ homepageitems.get(i).getName() + "&price=" +homepageitems.get(i).getPrice()+ "#portfolio" +"'" +
                    "data-bs-toggle = 'modal' >" +
                    "<div class='portfolio-hover' >" +
                        "<div class='portfolio-hover-content' ><i class='fa fa-plus fa-3x' ></i ></div >" +
                    "</div ><img class='img-fluid' src = '"+ homepageitems.get(i).getImage()+"' >" +
                    "</a >" +
                        "<div class='portfolio-caption' >" +
                            "<h4 >" + homepageitems.get(i).getName() + "</h4 >" +
                         "<p class='text-muted' >" + homepageitems.get(i).getPrice()+ "</p >" +
                        "</div > " +
                    "</div>");
            }
        %>
        </div>
    </div>
</section>
<section class="bg-light" id="team">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase section-heading">Chefs</h2>
                <h3 class="text-muted section-subheading">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/temp.webp">
                    <h4>Kay Garland</h4>
                    <p class="text-muted">chef</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/temp.webp">
                    <h4>Larry Parker</h4>
                    <p class="text-muted">chef</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/temp.webp">
                    <h4>Diana Pertersen</h4>
                    <p class="text-muted">chef</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="contact" style="background-image:url('assets/img/contact.jpg');">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase section-heading">Contact Us</h2>
                <h3 class="text-muted section-subheading">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <form id="contactForm" name="contactForm" novalidate="novalidate">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group mb-3"><input class="form-control" type="text" id="name" placeholder="Your Name *" required=""><small class="form-text text-danger flex-grow-1 help-block lead"></small></div>
                            <div class="form-group mb-3"><input class="form-control" type="email" id="email" placeholder="Your Email *" required=""><small class="form-text text-danger help-block lead"></small></div>
                            <div class="form-group mb-3"><input class="form-control" type="tel" placeholder="Your Phone *" required=""><small class="form-text text-danger help-block lead"></small></div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group mb-3"><textarea class="form-control" id="message" placeholder="Your Message *" required=""></textarea><small class="form-text text-danger help-block lead"></small></div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div><button class="btn btn-primary btn-xl text-uppercase" id="sendMessageButton" type="submit">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4"><span class="copyright">Copyright&nbsp;© Brand 2022</span></div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <ul class="list-inline quicklinks">
                    <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
                    <li class="list-inline-item"><a href="#">Terms of Use</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<a href="<%= request.getContextPath() %>/employee.jsp">Employee</a>
<a href="<%= request.getContextPath() %>/cart.jsp">cart</a>
<a href="employee.jsp">Employee Login</a>
<a href="ItemsGet">Admin Items</a>
</body>
</html>
