<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.FoodPlaza.pojo.Contactus" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Messages - Admin Panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f9f9f9;
        }
        .container {
            margin-top: 40px;
        }
        h2 {
            color: #ff6600;
        }
        table {
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }
    </style>
</head>
<body>

<jsp:include page="Header.jsp" />

<div class="container">
<form action="ContactUsServlet" method="post">
   <input type="hidden" name="action" value="view"></form>
    <h2 class="text-center mb-4">Contact Us Messages</h2>

    <%
        List<Contactus> contactList = (List<Contactus>) request.getAttribute("contactList");

        if (contactList != null && !contactList.isEmpty()) {
    %>
    <div class="table-responsive">
    
   
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
            
            
                <tr>
                    <th>Full Name</th>
                    <th>Contact No</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Message</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Contactus c : contactList) {
                %>
                <tr>
                    <td><%= c.getCustname() %></td>
                    <td><%= c.getContact() %></td>
                    <td><%= c.getCustemailId() %></td>
                    <td><%= c.getCustAddress() %></td>
                    <td><%= c.getMessage() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } else { %>
        <div class="alert alert-info text-center">
            No contact messages found.
        </div>
    <% } %>
</div>

<jsp:include page="Footer.jsp" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
