<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.FoodPlaza.pojo.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List - FoodPlazza</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #ffe0f0, #ffffff);
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin: 40px 0 20px 0;
            font-size: 2.5em;
            color: #d81b60;
        }

        .order-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .order-card {
            background-color: #fff0f5;
            border: 2px solid #f8bbd0;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            padding: 20px;
            width: 300px;
            transition: 0.3s;
        }

        .order-card:hover {
            transform: scale(1.03);
        }

        .order-card h3 {
            color: #c2185b;
            margin-bottom: 10px;
        }

        .order-card p {
            font-size: 16px;
            color: #333;
            margin: 5px 0;
        }

        .no-data {
            text-align: center;
            font-size: 20px;
            color: #d32f2f;
            margin: 40px;
        }
    </style>
</head>
<body>

<jsp:include page="Header.jsp" />

<h2>Your Orders</h2>

<%
    List<Order> orderList = (List<Order>) session.getAttribute("orderlist");
    if (orderList != null && !orderList.isEmpty()) {
%>
    <div class="order-container">
    <%
        for (Order o : orderList) {
    %>
        <div class="order-card">
            <h3>Order ID: <%= o.getOrderId() %></h3>
            <p><strong>Date:</strong> <%= o.getOrderDate() %></p>
            <p><strong>Total Bill:</strong> ₹<%= o.getTotalBill() %></p>
            <p><strong>Email:</strong> <%= o.getEmailId() %></p>
            <p><strong>Status:</strong> <%= o.getOrderStatus() %></p>
        </div>
    <%
        }
    %>
    </div>
<% } else { %>
    <p class="no-data">No orders found.</p>
<% } %>

<jsp:include page="Footer.jsp" />

</body>
</html>
