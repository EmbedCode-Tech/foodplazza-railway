<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.FoodPlaza.pojo.Customer" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: #f4f6f9;
	margin: 0;
	padding: 0;
	color: #333;
}

#templatemo_container {
	max-width: 1100px;
	margin: 40px auto;
	padding: 20px;
	background: white;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	border-radius: 12px;
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

/* Card layout */
.card-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.card {
	background: #ffffff;
	border: 1px solid #ddd;
	border-radius: 12px;
	padding: 20px;
	width: 300px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
	transition: transform 0.3s;
}

.card:hover {
	transform: scale(1.02);
}

.card h3 {
	margin-top: 0;
	color: #007BFF;
	font-size: 20px;
	margin-bottom: 10px;
}

.card p {
	margin: 6px 0;
	font-size: 15px;
}

.no-data {
	text-align: center;
	color: red;
	font-weight: bold;
	margin: 30px 0;
}
</style>
</head>
<body>

<jsp:include page="Header.jsp" />
<div id="templatemo_container">

	<%
	String[] Status = { 
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
	%>

	<h2>Customer List</h2>

	<%
	List<Customer> custlist = (List<Customer>) session.getAttribute("customerList");
	if (custlist != null && !custlist.isEmpty()) {
	%>
	<div class="card-container">
		<%
		for (Customer c : custlist) {
		%>
		<div class="card">
			<h3><%= c.getCustname() %></h3>
			<p><strong>Email:</strong> <%= c.getEmailId() %></p>
			<p><strong>Address:</strong> <%= c.getCustAddress() %></p>
			<p><strong>Contact No:</strong> <%= c.getCustContactNo() %></p>
			<p><strong>Location:</strong> <%= c.getCustLocation() %></p>
		</div>
		<%
		}
		%>
	</div>
	<% 
	} else {
	%>
		<p class="no-data">No Customer Available.</p>
	<%
	}
	%>
</div>

<jsp:include page="Footer.jsp" />
</body>
</html>
