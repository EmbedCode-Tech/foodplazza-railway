<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.FoodPlaza.pojo.Feedback"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #f8f9fa, #e0f7fa);
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin: 30px 0;
            font-size: 2em;
            color: #333;
        }

        .feedback-container {
            width: 90%;
            max-width: 1200px;
            margin: 0 auto 50px auto;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .feedback-card {
            background-color: white;
            border-left: 6px solid #00796B;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
        }

        .feedback-card:hover {
            transform: translateY(-5px);
        }

        .feedback-card h3 {
            margin: 0 0 10px;
            color: #00796B;
        }

        .feedback-details p {
            margin: 6px 0;
            font-size: 15px;
            color: #333;
        }

        .no-feedback {
            text-align: center;
            font-style: italic;
            color: #777;
            font-size: 18px;
            margin-top: 30px;
        }
    </style>
</head>
<body>

<jsp:include page="Header.jsp" />

<h2>All Feedback</h2>

<div class="feedback-container">
    <%
        List<Feedback> feedbackList = (List<Feedback>) request.getAttribute("feedbackList");
        if (feedbackList != null && !feedbackList.isEmpty()) {
            for (Feedback f : feedbackList) {
    %>
    <div class="feedback-card">
        <h3>Feedback ID: <%= f.getFeedbackid() %></h3>
        <div class="feedback-details">
            <p><strong>Customer Name:</strong> <%= f.getCustname() %></p>
            <p><strong>Contact No:</strong> <%= f.getCustContactNo() %></p>
            <p><strong>Email:</strong> <%= f.getCustemailId() %></p>
            <p><strong>Feedback:</strong> <%= f.getFeedback() %></p>
            <p><strong>Food Taste:</strong> <%= f.getFoodTaste() %></p>
            <p><strong>Service Review:</strong> <%= f.getServiceReview() %></p>
        </div>
    </div>
    <%
            }
        } else {
    %>
    <div class="no-feedback">No feedback found.</div>
    <%
        }
    %>
</div>

<jsp:include page="Footer.jsp" />

</body>
</html>
