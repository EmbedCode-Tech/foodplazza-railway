<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to FoodPlazza</title>

<style>
body {
	background-color: #ffff;
}

.jumbotron {
	background: url('images/indexdemo.png');
	
	color: white;
	text-shadow: 2px 2px 4px #000;
	height: 700px;
	display: flex;
	justify-content: center;
    align-items: top;
    text-align: center;
    color: white;
    text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.7);
}
.jumbotron h1 {
	font-size: 50px;
    margin: 10px 0;
}

.container.features {
	background-color: #ffff;
	padding: 50px 30px;
	
}

.features {
	padding: 60px 0;
	background-color: #4b2e2e;
}

.feature-box {
	background-color: #ffffff;
	border-radius: 15px;
	padding: 40px 10px;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.feature-box:hover {
	transform: translateY(-5px);
	box-shadow: 0 12px 24px rgba(0, 0, 0, 0.3);
}

.feature-box h3 {
	color: #333;
	font-weight: bold;
	margin-bottom: 15px;
}

.feature-box p {
	color: #666;
	font-size: 15px;
	margin-bottom: 25px;
}

.feature-box .btn {
	padding: 10px 20px;
	font-weight: bold;
	border-radius: 8px;
	text-transform: uppercase;
	letter-spacing: 1px;
}

.work.section {
    padding: 60px 20px;
    background: rgba(0, 0, 0, 0.6); 
    color: white;
}

.section-title {
    text-align: center;
    font-size: 36px;
    margin-bottom: 40px;
    color: #fff;
    text-shadow: 2px 2px 4px #000;
}


.work__container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 20px;
    max-width: 1200px;
    margin: 0 auto;
}


.work__img img {
    width: 100%;
    height: auto;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}


.work__img img:hover {
    transform: scale(1.05);
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.5);
}


</style>
</head>
<body>	

 <div align="center" style="color: red">
        <%
            String adminLoginSuccess = (String) request.getAttribute("adminloginsuccess");
            String adminName = (String) session.getAttribute("adminName");
            String customerLoginSuccess = (String) request.getAttribute("customerloginsuccess");
            String customerUserName = (String) session.getAttribute("CustomerUserName");

            if (adminLoginSuccess != null && adminName != null) {
        %>
                <p class="login-success"><%= adminLoginSuccess %> - <span class="admin-name"><%= adminName %></span></p>
        <%
            }

            if (customerLoginSuccess != null && customerUserName != null) {
        %>
                <p class="login-success"><%= customerLoginSuccess %> - <span class="customer-name"><%= customerUserName %></span></p>
        <%
            }
        %>
    </div>

	<div class="jumbotron text-center">
		<div>
			<h1>Welcome to FoodPlazza</h1>
			<p>Delicious food just a click away!</p>
		</div>
	</div>

	<div class="container features">
		<div class="row text-center">
			<div class="col-sm-4 feature-box">
				<h3>Explore Menu</h3>
				<p>Browse through our variety of cuisines and dishes.</p>
				<a href="CommonFoodServlet" class="btn btn-primary">View Menu</a>
			</div>
			<div class="col-sm-4 feature-box">
				<h3>Customer Login</h3>
				<p>Access your cart, orders, and profile.</p>
				<a href="Login.jsp" class="btn btn-success">Login</a>
			</div>
			<div class="col-sm-4 feature-box">
				<h3>Contact Us</h3>
				<p>Need help? Get in touch with our support team.</p>
				<a href="Contactus.jsp" class="btn btn-info">Contact</a>
			</div>
		</div>	
	</div>
	  <section class="work section" id="work">
		<h2 class="section-title" style="color: white; text-align: center; margin-top: 50px;">Hotel Special Food</h2>
		<div class="work__container bd-grid" style="display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 20px; padding: 20px;">
			<a href="#" class="work__img">
				<img src="images/Ice_Cream_pic16.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/templatemo_image_01.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/lambbbq.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/butter-chicken.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/chicken-biryani.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/chickentikkamsala.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/indianthali.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
			<a href="#" class="work__img">
				<img src="images/Manchow-Soup-Chinese-Restaurants-Dubai.jpg" alt="" style="width: 100%; border-radius: 10px;">
			</a>
		</div>
	</section>

	<jsp:include page="Footer.jsp" />

</body>
</html>
