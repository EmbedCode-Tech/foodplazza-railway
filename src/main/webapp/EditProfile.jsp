<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.FoodPlaza.pojo.Customer"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Profile</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #f4f4f4;
	background: url('images/editprofile.png');
	background-size: cover;
	margin: 0;
	padding: 0;
}

.main-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: calc(100vh - 100px);
	padding-top: 40px;
}

.form-container {
	background-color: rgba(255, 255, 255, 0.85); 
	padding: 30px 40px;
	border-radius: 12px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
	width: 400px;
	backdrop-filter: blur(6px);
	border: 1px solid rgba(200, 200, 200, 0.3);
}

.form-container h2 {
	text-align: center;
	margin-bottom: 25px;
	color: #333;
}

.form-container label {
	display: block;
	margin-bottom: 6px;
	font-weight: bold;
	color: #444;
}

.form-container input[type="text"], .form-container input[type="email"],
	.form-container input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
	transition: border-color 0.3s ease;
}

.form-container input[type="text"]:focus, .form-container input[type="email"]:focus,
	.form-container input[type="password"]:focus {
	border-color: #007bff;
	outline: none;
}

.form-container input[type="submit"] {
	width: 100%;
	padding: 12px;
	background-color: #28a745;
	border: none;
	border-radius: 5px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
}

.form-container input[type="submit"]:hover {
	background-color: #218838;
}

.message {
	text-align: center;
	margin-top: 15px;
	font-weight: bold;
}

.success {
	color: white;
}

.error {
	color: red;
}
</style>
</head>
<body>
<div class="message success">
				<%=request.getAttribute("Profileupdate") != null ? request.getAttribute("Profileupdate") : ""%>
			</div>
			<div class="message error">
				<%=request.getAttribute("ProfileNotupdate") != null ? request.getAttribute("ProfileNotupdate") : ""%>
			</div>

	<%
	Customer c = (Customer) request.getAttribute("customer");
	%>
	<div class="main-wrapper">
		<div class="form-container">
			<h2>Edit Profile</h2>
			<form action="CommonCustomerServlet?action=updateprofile"
				method="post">
				<label for="custName">Name:</label> <input type="text"
					name="custName" value="<%=c.getCustname()%>" required> <label
					for="custEmail">Email:</label> <input type="email" name="custEmail"
					value="<%=c.getEmailId()%>" readonly> <label
					for="custAddress">Address:</label> <input type="text"
					name="custAddress" value="<%=c.getCustAddress()%>" required>

				<label for="custContact">Contact:</label> <input type="text"
					name="custContact" value="<%=c.getCustContactNo()%>" required>

				<label for="custPassword">Password:</label> <input type="password"
					name="custPassword" value="<%=c.getCustPassword()%>" required>

				<input type="submit" value="Update">
			</form>

					</div>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>
