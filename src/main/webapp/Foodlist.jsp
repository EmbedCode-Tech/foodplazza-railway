<%@page import="com.FoodPlaza.pojo.Admin"%>
<%@page import="com.FoodPlaza.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	background: #f4f6f9;
	color: #333;
}

#templatemo_container {
	max-width: 1200px;
	margin: 40px auto;
	padding: 20px;
	background: white;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #1a1a1a;
}

.status-message {
	background-color: #e0f7fa;
	color: #006064;
	padding: 12px 20px;
	border-radius: 6px;
	margin: 10px auto;
	text-align: center;
	width: 60%;
	font-weight: 500;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 20px;
}

.food-card {
	width: 250px;
	background: #fff;
	padding: 20px;
	border-radius: 12px;
	box-shadow: 0 2px 8px rgba(0,0,0,0.1);
	transition: transform 0.2s;
}

.food-card:hover {
	transform: scale(1.03);
}

.food-card h3 {
	margin-top: 0;
	color: #007BFF;
}

.food-card p {
	margin: 5px 0;
}

.action-btn {
	text-decoration: none;
	display: inline-block;
	margin: 10px 5px 0 0;
	padding: 8px 14px;
	border-radius: 6px;
	color: #fff;
	font-weight: bold;
	transition: background-color 0.3s ease;
}

.edit-btn { background-color: #28a745; }
.edit-btn:hover { background-color: #218838; }

.delete-btn { background-color: #dc3545; }
.delete-btn:hover { background-color: #c82333; }

.cart-btn { background-color: #17a2b8; }
.cart-btn:hover { background-color: #138496; }

.no-food {
	text-align: center;
	color: #999;
	font-size: 18px;
	margin-top: 20px;
}
</style>
</head>

<body>
<%
	String CustomerUserName = (String) session.getAttribute("CustomerUserName");
	String AdminName = (String) session.getAttribute("adminName");
%>

<jsp:include page="Header.jsp" />

<div id="templatemo_container">

	<%
		String[] Status = {
			(String) request.getAttribute("AddedToCart"),
			(String) request.getAttribute("NotAddedtocart"),
			(String) request.getAttribute("DeleteCustomer"),
			(String) request.getAttribute("UpdateSuccess"),
			(String) request.getAttribute("UpdateunSuccess")
		};
		for (String msg : Status) {
			if (msg != null) {
	%>
		<div class="status-message"><%=msg%></div>
	<%
			}
		}
		List<Food> foodlist = (List<Food>) session.getAttribute("foodlist");
	%>

	<h2>Food Menu</h2>

	<div class="card-container">
	<%
		if (foodlist != null && !foodlist.isEmpty()) {
			for (Food f : foodlist) {
	%>
		<div class="food-card">
			<h3><%=f.getFoodname()%></h3>
			<p><strong>Price:</strong> ₹<%=f.getFoodprice()%></p>
			<p><strong>Category:</strong> <%=f.getFoodcategory()%></p>
			<p><strong>Type:</strong> <%=f.getFoodtype()%></p>

			<%
			if (AdminName != null) {
			%>
				<a href="CommonFoodServlet?action=edit&foodId=<%=f.getFoodid()%>" class="action-btn edit-btn">Edit</a>
				<a href="CommonFoodServlet?action=delete&foodId=<%=f.getFoodid()%>" class="action-btn delete-btn">Delete</a>
			<%
			} else if (CustomerUserName != null) {
			%>
				<a href="CommonFoodServlet?action=addtocart&foodId=<%=f.getFoodid()%>" class="action-btn cart-btn">Add to Cart</a>
			<%
			}
			%>
		</div>
	<%
			}
		} else {
	%>
		<div class="no-food">No food items available.</div>
	<%
		}
	%>
	</div>
</div>

<jsp:include page="Footer.jsp" />
</body>
</html>
