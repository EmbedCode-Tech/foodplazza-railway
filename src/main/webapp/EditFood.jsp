<%@page import="com.FoodPlaza.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Food Item</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #343a40;
        }
    </style>
</head>
<body>
<%
    Food f = (Food) request.getAttribute("food");
    if (f == null) {
%>
    <div class="alert alert-danger" role="alert">
        Food not found.
    </div>
<%
    return;
    }
%>

<div class="container mt-5">
    <h2 class="mb-4">Edit Food Details</h2>
    <form action="CommonFoodServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="foodId" value="<%= f.getFoodid() %>">

        <div class="mb-3">
            <label class="form-label">Food Name:</label>
            <input type="text" class="form-control" name="foodName" value="<%= f.getFoodname() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Food Category:</label>
            <input type="text" class="form-control" name="foodCategory" value="<%= f.getFoodcategory() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Food Type:</label>
            <input type="text" class="form-control" name="foodType" value="<%= f.getFoodtype() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Food Price:</label>
            <input type="number" class="form-control" name="foodPrice" value="<%= f.getFoodprice() %>" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Food</button>
        <a href="CommonFoodServlet?action=view" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
