
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

		<title>Laptops</title>

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
						<li><a href="home">Home</a></li>
						<li><a href="hotdeals">Hot Deals</a></li>
						<li class="active"><a href="laptops">Laptops</a></li>
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
					<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
                                                    <form action="laptops">
							<h3 class="aside-title">Brand</h3>
							<c:set var="cat" value="${requestScope.cats}"/>
                                                        <c:set var="ci" value="${requestScope.cid}"/>
                                                        
                                                            <c:forEach begin="0" end="${cat.size()-1}"  var="i">
                                                                <input type="checkbox" name="id" value="${cat.get(i).getScid()}" 
                                                                    ${ci[i]?"checked":""}/>
                                                                    ${cat.get(i).getScname()}
                                                                <br/>
                                                            </c:forEach>
                                                         <br/>
                                                         <h3 class="aside-title">Sort By</h3>   
                                                         <c:set var="check" value="${requestScope.checked}"></c:set>
                                                         <input type="radio" name="sortby" value="0" <c:if test="${check == 0}">checked</c:if>/>&nbsp; Default<br/>
                                                         <input type="radio" name="sortby" value="1" <c:if test="${check == 1}">checked</c:if>/>&nbsp; Release Date<br/>
                                                         <input type="radio" name="sortby" value="2" <c:if test="${check == 2}">checked</c:if>/>&nbsp; Price &darr; <br/>
                                                         <input type="radio" name="sortby" value="3" <c:if test="${check == 3}">checked</c:if>/>&nbsp; Price &uarr;<br/><br/>
                                                         <input class="btn btn-danger" type="submit" value="Get"/>
                                                    </form> 
						</div>

					</div>
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
                                            <form name="f" action="" method="post">
                                                

						<!-- store products -->
						<div class="row">
                                                    
                                                    <c:set var="count" value="0" scope="page" />

                                                    <c:forEach items="${requestScope.data}" var="i">
                                                        
                                                        <div class="col-md-4 col-xs-6">
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
                                                                            <button class="add-to-cart-btn" onclick="cart(${i.pid})"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>                            
                                                                    </c:if>
                                                                    <c:if test="${sessionScope.account == null}">
                                                                        <div class="add-to-cart">
                                                                            <button class="add-to-cart-btn" onclick="notice()"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>                         
                                                                    </c:if>
									
								</div>
							</div>
                                                                                
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        
                                                        <c:if test="${count%2==0}">
                                                            <div class="clearfix visible-sm visible-xs"></div>
                                                        </c:if>
                                                            
                                                        <c:if test="${count%3==0}">
                                                            <div class="clearfix visible-lg visible-md"></div>
                                                        </c:if>  
                                                        
                                                    </c:forEach>
                                                            
					</div>	
                                                <div class="store-filter clearfix">
                                                    <c:set var="page" value="${requestScope.page}"/>
                                                    <ul class="store-pagination">
                                                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                                            <li><a class="${i==page?"active":""}" 
                                                                   href="laptops?page=${i}${requestScope.getid}">${i}</a></li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
					</form>
					<!-- /STORE -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
                </div>
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
									<li><a href="#">My Account</a></li>
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
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
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
                    function cart(id) {
                        document.f.action="laptops?id=" + id;
                        document.f.method="post";
                        document.f.submit();
                    }
                    
                    function notice() {
                        alert("You must login to 'Add to cart'");
                        document.f.action="laptops";
                        document.f.method="get";
                        document.f.submit();
                    }
                </script>
	</body>
</html>
