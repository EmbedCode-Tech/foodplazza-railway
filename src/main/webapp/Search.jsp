<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search food</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #f8f9fa;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .search-container {
        max-width: 600px;
        margin: 80px auto;
        padding: 30px;
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
    }

    .form-control::placeholder {
        color: #999;
    }

    .btn-search {
        background-color: #007bff;
        color: white;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    .btn-search:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

    <%@ include file="Header.jsp" %>

    <div class="search-container">
        <h2 class="text-center mb-4">Search Food</h2>
        <form action="CommonFoodServlet" method="post">
            <input type="hidden" name="action" value="search">
            <div class="mb-3">
                <input type="text" class="form-control" name="foodId" id="foodId" placeholder="Enter Food ID or Name" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-search">Search</button>
            </div>
        </form>
    </div>

    <%@ include file="Footer.jsp" %>

</body>
</html>