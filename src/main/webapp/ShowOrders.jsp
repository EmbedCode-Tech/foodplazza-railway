<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.FoodPlaza.pojo.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List - FoodPlazza</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h2 {
            text-align: center;
            margin-top: 30px;
        }
        table {
            width: 70%;
            margin: auto;
            margin-bottom: 30px;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0px 0px 10px #aaa;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #333;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .bill-section {
            text-align: center;
            margin: 40px auto;
        }
        .bill {
            font-size: 20px;
            color: green;
            font-weight: bold;
            margin: 10px;
        }
        .pay-btn {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
        }
        .pay-btn:hover {
            background-color: #218838;
        }
        .qr-code {
            margin-top: 20px;
        }
        .qr-code img {
            height: 180px;
            width: 180px;
        }
    </style>
</head>
<body>

<h2>Your Orders</h2>

<%
    List<Order> orderList = (List<Order>) session.getAttribute("orderlist");
    double totalBill = 0;

    if (orderList != null && !orderList.isEmpty()) {
%>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Total Bill</th>
            <th>Customer Email</th>
            <th>Status</th>
        </tr>
        <%
            for (Order o : orderList) {
                totalBill += o.getTotalBill();
        %>
        <tr>
            <td><%= o.getOrderId() %></td>
            <td><%= o.getOrderDate() %></td>
            <td>₹ <%= o.getTotalBill() %></td>
            <td><%= o.getEmailId() %></td>
            <td><%= o.getOrderStatus() %></td>
        </tr>
        <% } %>
    </table>

    <div class="bill-section">
        <div class="bill">Total Bill: ₹ <%= totalBill %></div>
        <form action="ShowQR.jsp" method="post">
            <button class="pay-btn">Pay Now</button>
        </form>
    </div>

<% } else { %>
    <p style="text-align: center; color: red;">No orders found.</p>
<% } %>

<jsp:include page="Footer.jsp" />
</body>
</html>
