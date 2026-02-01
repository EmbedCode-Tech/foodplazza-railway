<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thank You - FoodPlazza</title>
    <style>
        body {
            text-align: center;
            background: linear-gradient(to bottom right, #ffe6f0, #ffffff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 50px;
        }
        .thank-you-box {
            background-color: #fff0f5;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(255, 105, 180, 0.2);
            max-width: 600px;
            margin: auto;
            padding: 40px 30px;
        }
        h2 {
            color: #ff1493;
            font-size: 32px;
            margin-bottom: 15px;
        }
        p {
            font-size: 18px;
            color: #444;
            line-height: 1.6;
        }
        .highlight {
            font-weight: bold;
            color: #c2185b;
        }
        .home-btn {
            display: inline-block;
            margin-top: 30px;
            padding: 12px 25px;
            font-size: 16px;
            background-color: #ff69b4;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .home-btn:hover {
            background-color: #e91e63;
        }
    </style>
</head>
<body>

    <div class="thank-you-box">
        <h2>💗 Thank you for your payment!</h2>
        <p>Your order is being processed and will be delivered shortly.</p>
        <p class="highlight">We sincerely appreciate your trust in <strong>FoodPlazza</strong>.</p>
        <p>It was a pleasure serving you. We hope to see you again soon!</p>
        <p style="font-size: 20px;">❤️ Thank you for visiting <strong>FoodPlazza</strong>!</p>

        <a class="home-btn" href="index.jsp">Back to Home</a>
    </div>

</body>
</html>
