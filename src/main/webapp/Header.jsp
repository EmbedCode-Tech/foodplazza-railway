
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FoodPlazza Header</title>
  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        .navbar-nav > li > a {
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    String AdminName = (String) session.getAttribute("adminName");
    String CustomerUserName = (String) session.getAttribute("CustomerUserName");
%>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Jadhav FoodPlazza</a>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menuItems">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>

    <div class="collapse navbar-collapse" id="menuItems">
      <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="CommonFoodServlet">Food Menu</a></li>
        <li><a href="Search.jsp">Search</a></li>

        <% if (AdminName == null && CustomerUserName == null) { %>
            <li><a href="Register.jsp">Register</a></li>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Contactus.jsp">Contact Us</a></li>
        <% } %>

        <% if (AdminName != null) { %>
            <li><a href="CommonCustomerServlet">Show Customer</a></li>
            <li><a href="AddFood.jsp">Add Food</a></li>
            <li><a href="CommonCartServlet">Show Orders</a></li>
         <li><a href="CommonFeedbackServlet?action=viewfeedback">Show Feedback</a></li>
          
        <% } %>

        <% if (CustomerUserName != null) { %>
            <li><a href="CommonCustomerServlet?action=editprofile">Edit Profile</a></li>
            <li><a href="CommonFoodServlet?action=viewcart">Show Cart</a></li>
            <li><a href="Feedback.jsp">Feedback</a></li>
            <li><a href="CommonOrderServlet?action=vieworder">Show Bill</a></li>
          
        <% } %>

        <% if (CustomerUserName != null || AdminName != null) { %>
            <li><a href="CommonLoginServlet?action=Logout">Logout</a></li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>
