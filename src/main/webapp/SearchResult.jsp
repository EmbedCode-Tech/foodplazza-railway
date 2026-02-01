<%@ page import="com.FoodPlaza.pojo.Food" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="Header.jsp" %>

<div class="container mt-5">
    <h2 class="text-center">Search Result</h2>

    <%
        String notFound = (String) request.getAttribute("notFound");
        Food f = (Food) request.getAttribute("searchFood");

        if (notFound != null) {
    %>
        <div class="alert alert-warning text-center mt-4"><%= notFound %></div>
    <%
        } else if (f != null) {
    %>
        <table class="table table-bordered mt-4">
            <thead class="table-dark">
                <tr>
                    <th>Food ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= f.getFoodid() %></td>
                    <td><%= f.getFoodname() %></td>
                    <td><%= f.getFoodprice() %></td>
                    <td><%= f.getFoodcategory() %></td>
                    <td><%= f.getFoodtype() %></td>
                </tr>
            </tbody>
        </table>
    <%
        }
    %>
</div>

<%@ include file="Footer.jsp" %>

</body>
</html>
