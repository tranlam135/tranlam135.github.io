
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="ourDate" class="java.util.Date"/>
<jsp:setProperty name="ourDate" property="time" value="${ourDate.time - 86400000*270}"/>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro.vn</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +84-369-909-625</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> electrovn@gmail.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 162 Thai Ha</a></li>
					</ul>
					<ul class="header-links pull-right">
						<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                                                <c:if test="${sessionScope.account == null}">
                                                    <li><a href="login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                                                </c:if>
                                                    
                                                <c:if test="${sessionScope.account != null}">
                                                    <c:if test="${sessionScope.account.role == 0}">
                                                        <li><a href="listmanage"><i class="fa fa-user-o"></i> Hello ${sessionScope.account.user}</a></li>
                                                    </c:if>
                                                    <c:if test="${sessionScope.account.role == 1}">
                                                        <li><a href="profile"><i class="fa fa-user-o"></i> Hello ${sessionScope.account.user}</a></li>
                                                    </c:if>
                                                    <li><a href="logout"><i class="fa fa-user-o"></i> Logout</a></li>
                                                </c:if>
						
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="home" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
                                                                <form action="search">
                                                                        <input name="searchname" class="input" placeholder="Search here">
                                                                        <button type="submit" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
                                                            <!-- Cart -->
                                                            <c:if test="${sessionScope.account != null}">
								<div>
                                                                    <a href="cart">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
                                                                                <div class="qty">${sessionScope.size}</div>
                                                                    </a>
								</div>
                                                            </c:if> 
                                                        <!-- /Cart -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
                        </div>
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="home">Home</a></li>
						<li><a href="hotdeals">Hot Deals</a></li>
						<li><a href="laptops">Laptops</a></li>
						<li><a href="#">Smartphones</a></li>
						<li><a href="#">Cameras</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop01.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Laptops<br>Collection</h3>
								<a href="laptops" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
                                        
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
                                                            <img src="./img/shop04.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Smartphones<br>Collection</h3>
								<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop02.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Cameras<br>Collection</h3>
								<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">New Products</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab1">Laptops</a></li>
									<li><a data-toggle="tab" href="#tab1">Smartphones</a></li>
									<li><a data-toggle="tab" href="#tab1">Cameras</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
                                            <form name="x" action="" method="post">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active">
                                                                        <%--<fmt:formatDate value="${ourDate}" pattern="dd/MM/yyyy"/>--%>
									<div class="products-slick" data-nav="#slick-nav-1">
                                                                                            
                                                                            <c:forEach items="${requestScope.data1}" var="i">
                                                                               
										<!-- product -->
										<div class="product">
											<div class="product-img">
                                                                                            <img src="./img/Laptop/${i.image}" alt="">
												<div class="product-label">
                                                                                                    <c:if test="${i.sale_off != 0}">
													<span class="sale">-${i.sale_off}%</span>
                                                                                                    </c:if>
                                                                                                    <c:if test="${i.release_date > ourDate}">
													<span class="new">NEW</span>
                                                                                                    </c:if>
													
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${i.subCat.scname}</p>
												<h3 class="product-name"><a href="product?pid=${i.pid}">${i.name}</a></h3>
                                                                                                <c:if test="${i.sale_off != 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price * (100 - i.sale_off) / 100}" type = "currency"/>
                                                                                                        <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></del>
                                                                                                    </h4>
                                                                                                </c:if>
                                                                                                <c:if test="${i.sale_off == 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></h4>
                                                                                                </c:if>
												
											</div>
											<c:if test="${sessionScope.account != null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="cartx(${i.pid})"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                            
                                                                                        </c:if>
                                                                                        <c:if test="${sessionScope.account == null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="noticex()"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                         
                                                                                        </c:if>
                                                                                    </div>
										<!-- /product -->
                                                                            </c:forEach>

									</div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
                                            </form>
					</div>
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							<ul class="hot-deal-countdown">
								<li>
									<div>
                                                                            <h3 id="days"></h3>
										<span>Days</span>
									</div>
								</li>
								<li>
									<div>
                                                                            <h3 id="hours"></h3>
										<span>Hours</span>
									</div>
								</li>
								<li>
									<div>
                                                                            <h3 id="mins"></h3>
										<span>Mins</span>
									</div>
								</li>
								<li>
									<div>
                                                                            <h3 id="secs"></h3>
										<span>Secs</span>
									</div>
								</li>
							</ul>
							<h2 class="text-uppercase">hot deal this week</h2>
							<p>New Collection Up to 30% OFF</p>
							<a class="primary-btn cta-btn" href="hotdeals">Shop now</a>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
                <form name="y" action="" method="post">
                    
                
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Top selling</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
									<li><a data-toggle="tab" href="#tab2">Smartphones</a></li>
									<li><a data-toggle="tab" href="#tab2">Cameras</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab2" class="tab-pane fade in active">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
                                                                            <c:forEach items="${requestScope.data2}" var="i">
										<div class="product">
											<div class="product-img">
                                                                                            <img src="./img/Laptop/${i.image}" alt="">
												<div class="product-label">
                                                                                                    <c:if test="${i.sale_off != 0}">
													<span class="sale">-${i.sale_off}%</span>
                                                                                                    </c:if>
                                                                                                    <c:if test="${i.release_date > ourDate}">
													<span class="new">NEW</span>
                                                                                                    </c:if>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${i.subCat.scname}</p>
												<h3 class="product-name"><a href="product?pid=${i.pid}">${i.name}</a></h3>
                                                                                                <c:if test="${i.sale_off != 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price * (100 - i.sale_off) / 100}" type = "currency"/>
                                                                                                        <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></del>
                                                                                                    </h4>
                                                                                                </c:if>
                                                                                                <c:if test="${i.sale_off == 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></h4>
                                                                                                </c:if>
											</div>
											<c:if test="${sessionScope.account != null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="carty(${i.pid})"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                            
                                                                                        </c:if>
                                                                                        <c:if test="${sessionScope.account == null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="noticey()"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                         
                                                                                        </c:if>
										</div>
										<!-- /product -->
                                                                            </c:forEach>
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
                </form>
		<!-- /SECTION -->
                
		<!-- SECTION -->
                <form name="z" action="" method="post">
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Top sale</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
									<li><a data-toggle="tab" href="#tab2">Smartphones</a></li>
									<li><a data-toggle="tab" href="#tab2">Cameras</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab2" class="tab-pane fade in active">
									<div class="products-slick" data-nav="#slick-nav-3">
										<!-- product -->
                                                                            <c:forEach items="${requestScope.data3}" var="i">
										<div class="product">
											<div class="product-img">
                                                                                            <img src="./img/Laptop/${i.image}" alt="">
												<div class="product-label">
                                                                                                    <c:if test="${i.sale_off != 0}">
													<span class="sale">-${i.sale_off}%</span>
                                                                                                    </c:if>
                                                                                                    <c:if test="${i.release_date > ourDate}">
													<span class="new">NEW</span>
                                                                                                    </c:if>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${i.subCat.scname}</p>
												<h3 class="product-name"><a href="product?pid=${i.pid}">${i.name}</a></h3>
                                                                                                <c:if test="${i.sale_off != 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price * (100 - i.sale_off) / 100}" type = "currency"/>
                                                                                                        <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></del>
                                                                                                    </h4>
                                                                                                </c:if>
                                                                                                <c:if test="${i.sale_off == 0}">
                                                                                                    <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.price}" type = "currency"/></h4>
                                                                                                </c:if>
											</div>
											<c:if test="${sessionScope.account != null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="cartz(${i.pid})"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                            
                                                                                        </c:if>
                                                                                        <c:if test="${sessionScope.account == null}">
                                                                                            <div class="add-to-cart">
                                                                                                <button class="add-to-cart-btn" onclick="noticez()"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                                                            </div>                         
                                                                                        </c:if>
										</div>
										<!-- /product -->
                                                                            </c:forEach>
									</div>
									<div id="slick-nav-3" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
                </form>
		<!-- /SECTION -->

		<!-- NEWSLETTER -->
		<div id="newsletter" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="newsletter">
							<p>Sign Up for the <strong>NEWSLETTER</strong></p>
							<form>
								<input class="input" type="email" placeholder="Enter Your Email">
								<button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
							</form>
							<ul class="newsletter-follow">
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-instagram"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-pinterest"></i></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /NEWSLETTER -->

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">About Us</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
								<ul class="footer-links">
									<li><a href="#"><i class="fa fa-map-marker"></i>162 Thai Ha</a></li>
									<li><a href="#"><i class="fa fa-phone"></i>+84-369-909-625</a></li>
									<li><a href="#"><i class="fa fa-envelope-o"></i>electrovn@gmail.com</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Categories</h3>
								<ul class="footer-links">
									<li><a href="hotdeals">Hot deals</a></li>
									<li><a href="laptops">Laptops</a></li>
									<li><a href="#">Smartphones</a></li>
									<li><a href="#">Cameras</a></li>
								</ul>
							</div>
						</div>

						<div class="clearfix visible-xs"></div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Information</h3>
								<ul class="footer-links">
									<li><a href="#">About Us</a></li>
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Orders and Returns</a></li>
									<li><a href="#">Terms & Conditions</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Service</h3>
								<ul class="footer-links">
									<li><a href="profile">My Account</a></li>
									<li><a href="#">View Cart</a></li>
									<li><a href="#">Checkout</a></li>
									<li><a href="#">Track My Order</a></li>
									<li><a href="#">Help</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

			<!-- bottom footer -->
			<div id="bottom-footer" class="section">
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-12 text-center">
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
							</ul>
							<span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>
						</div>
					</div>
						<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /bottom footer -->
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>
                <script>
                    function cartx(id) {
                        document.x.action="home?id=" + id;
                        document.x.submit();
                    }
                    
                    function noticex() {
                        alert("You must login to 'Add to cart'");
                        document.x.action="home";
                        document.x.method="get";
                        document.x.submit();
                    }
                </script>
                <script>
                    function carty(id) {
                        document.y.action="home?id=" + id;
                        document.y.submit();
                    }
                    
                    function noticey() {
                        alert("You must login to 'Add to cart'");
                        document.y.action="home";
                        document.y.method="get";
                        document.y.submit();
                    }
                </script>
                <script>
                    function cartz(id) {
                        document.z.action="home?id=" + id;
                        document.z.submit();
                    }
                    
                    function noticez() {
                        alert("You must login to 'Add to cart'");
                        document.z.action="home";
                        document.z.method="get";
                        document.z.submit();
                    }
                </script>
                <script>
// Set the date we're counting down to
var countDownDate = new Date("Nov 14, 2022 23:59:59").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

  // Get today's date and time
  var now = new Date().getTime();
    
  // Find the distance between now and the count down date
  var distance = countDownDate - now;
    
  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Output the result in an element with id="demo"
  document.getElementById("days").innerHTML = days + "";
  document.getElementById("hours").innerHTML = hours + "";
  document.getElementById("mins").innerHTML = minutes + "";
  document.getElementById("secs").innerHTML = seconds + "";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("days").innerHTML = "EXPIRED";
    document.getElementById("hours").innerHTML = "EXPIRED";
    document.getElementById("mins").innerHTML = "EXPIRED";
    document.getElementById("secs").innerHTML = "EXPIRED";
  }
}, 1000);
</script>
	</body>
</html>
