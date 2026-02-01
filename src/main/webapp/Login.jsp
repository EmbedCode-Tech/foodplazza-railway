<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Food Plaza</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-image: url("images/login.png");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	margin: 0;
	padding: 0;
}

form {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 80vh;
}

table {
	border-collapse: separate;
	border-spacing: 10px;
	background-color: rgba(255, 255, 255, 0.4); 
	padding: 30px 40px;
	border-radius: 15px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
}

caption {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 15px;
	color: #ffffff;
}

th {
	text-align: left;
	color: #333;
	padding: 6px 10px 6px 0;
}

td {
	padding: 6px 0;
}

input[type="email"], input[type="password"], select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 14px;
}

input[type="submit"], input[type="reset"] {
	padding: 10px 25px;
	font-size: 15px;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-weight: bold;
	transition: background 0.3s;
}

input[type="submit"] {
	background-color: #28a745;
	color: #fff;
}

input[type="submit"]:hover {
	background-color: #218838;
}

input[type="reset"] {
	background-color: #dc3545;
	color: #fff;
}

input[type="reset"]:hover {
	background-color: #c82333;
}

a {
	font-size: 14px;
	color: #007bff;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<% String CustomerUserName = (String) session.getAttribute("CustomerUserName"); %>
	<% String AdminUserName = (String) session.getAttribute("AdminUserName"); %>
	<%if (AdminUserName != null ){
	String status = (String)request.getAttribute("adminloginerror");
} %>
	<form action="CommonLoginServlet" method="post">
		<input type="hidden" name="action" value="login">
		<table>
			<caption>Enter Login Details</caption>

			<tr>
				<th>Login Type</th>
				<td><select name="logintype" id="logintype" required>
						<option value="">Select</option>
						<option value="Admin">Admin</option>
						<option value="Customer">Customer</option>
				</select></td>
			</tr>

			<tr>
				<th>Email Id</th>
				<td><input type="email" name="EmailId" id="EmailId"
					placeholder="Enter Email Id" required></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><input type="password" name="Password" id="Password"
					placeholder="Enter Your Password" required></td>
			</tr>

			<tr>
				<td colspan="2"><a href="ChangePassword.jsp">Forget
						Password?</a></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>

	<jsp:include page="Footer.jsp" />

</body>
</html>
