<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us - FoodPlazza</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f8f9fa;
        }
        .contact-form {
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            margin-top: 30px;
        }
        .form-control:focus {
            border-color: #ff6600;
            box-shadow: 0 0 0 0.2rem rgba(255,102,0,.25);
        }
        .btn-orange {
            background-color: #ff6600;
            color: white;
        }
        .btn-orange:hover {
            background-color: #e65c00;
        }
    </style>
</head>
<body>

    <jsp:include page="Header.jsp" />


    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 contact-form">
                <h2 class="text-center mb-4">Contact Us</h2>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
    <div class="alert alert-info text-center"><%= msg %></div>
<% } %>
                <form action="ContactUsServlet" method="post">
                    <input type="hidden" name="action" value="add">
                    <div class="mb-3">
                        <label for="custname" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="custname" name="custname" placeholder="Enter your full name" required>
                    </div>
                    <div class="mb-3">
                        <label for="custemail" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="custemail" name="custemail" placeholder="example@domain.com" required>
                    </div>
                    <div class="mb-3">
                        <label for="contact" class="form-label">Contact Number</label>
                        <input type="tel" class="form-control" id="contact" name="contact" placeholder="10-digit mobile number" pattern="[0-9]{10}" required>
                    </div>
                    <div class="mb-3">
                        <label for="custaddress" class="form-label">Address</label>
                        <textarea class="form-control" id="custaddress" name="custaddress" rows="2" placeholder="Your address here..." required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="message" class="form-label">Message</label>
                        <textarea class="form-control" id="message" name="message" rows="4" placeholder="Write your message..." required></textarea>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-orange">Send Message</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="Footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
