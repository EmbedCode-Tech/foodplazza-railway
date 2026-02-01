<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Feedback - FoodPlazza</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f9f9f9;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            margin-top: 60px;
            max-width: 600px;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #28a745;
        }

        .btn-submit {
            width: 100%;
            background-color: #28a745;
            color: white;
        }

        .btn-submit:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Feedback</h2>
        <form action="CommonFeedbackServlet" method="post">
            <input type="hidden" name="action" value="addfeedback"/>

            <div class="mb-3">
                <label for="custname" class="form-label">Full Name</label>
                <input type="text" class="form-control" name="custname" id="custname" required>
            </div>

            <div class="mb-3">
                <label for="custContactNo" class="form-label">Contact Number</label>
                <input type="text" class="form-control" name="custContactNo" id="custContactNo" required>
            </div>

            <div class="mb-3">
                <label for="customerEmail" class="form-label">Email Address</label>
                <input type="email" class="form-control" name="custemailId" id="customerEmail" required>
            </div>

            <div class="mb-3">
                <label for="feedback" class="form-label">Your Feedback</label>
                <textarea class="form-control" id="feedback" name="feedback" rows="5" required></textarea>
            </div>

            <div class="mb-3">
                <label for="foodTaste" class="form-label">Food Taste</label>
                <select class="form-select" id="foodTaste" name="foodTaste" required>
                    <option value="">-- Select --</option>
                    <option value="Excellent">Excellent</option>
                    <option value="Good">Good</option>
                    <option value="Average">Average</option>
                    <option value="Poor">Poor</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="serviceReview" class="form-label">Service Review</label>
                <select class="form-select" id="serviceReview" name="serviceReview" required>
                    <option value="">-- Select --</option>
                    <option value="Very Satisfactory">Very Satisfactory</option>
                    <option value="Satisfactory">Satisfactory</option>
                    <option value="Needs Improvement">Needs Improvement</option>
                    <option value="Unsatisfactory">Unsatisfactory</option>
                </select>
            </div>

            <button type="submit" class="btn btn-submit">Submit Feedback</button>
        </form>
    </div>
</body>
</html>
