<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pay Your Bill</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h2 {
            margin-top: 40px;
        }
        .qr-box {
            margin-top: 30px;
        }
        .qr-box img {
            width: 220px;
            height: 220px;
            border: 2px solid #ccc;
            padding: 10px;
            background-color: white;
        }
        .confirm-btn {
            margin-top: 30px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .confirm-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h2>Scan & Pay using Google Pay</h2>
    <div class="qr-box">
        <img src="images/QRCode.jpg" alt="Google Pay QR Code">
        <p>UPI ID: <strong>rohit@upi</strong></p>
    </div>

    <form action="ThankYou.jsp" method="post">
        <button class="confirm-btn">I Have Paid</button>
    </form>

</body>
</html>
