<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 * {
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        margin: 0;
        padding: 0;
        background-image: url("images/Changepass.png");
        background-size: cover;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        background-color: rgba(255, 255, 255, 0.3);
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 500px;
        animation: fadeIn 0.6s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    form caption {
        font-size: 22px;
        font-weight: bold;
        margin-bottom: 20px;
        color: #ffffff;
        display: block;
        text-align: center;
    }

    table {
        width: 100%;
        
    }

    th {
        text-align: left;
        padding: 10px 0;
        color: #ffffff;
    }

    td {
        padding: 10px 0;
    }

    input[type="email"],
    input[type="password"],
    select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ced4da;
        border-radius: 8px;
        font-size: 15px;
        background-color: #f8f9fa;
        transition: border-color 0.3s ease;
    }

    input[type="email"]:focus,
    input[type="password"]:focus,
    select:focus {
        outline: none;
        border-color: #4a90e2;
        background-color: #fff;
    }

    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        font-size: 15px;
        font-weight: bold;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        transition: all 0.3s ease-in-out;
    }

    input[type="submit"] {
        background-color: #28a745;
        color: white;
        margin-right: 10px;
    }

    input[type="reset"] {
        background-color: #dc3545;
        color: white;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }

    input[type="reset"]:hover {
        background-color: #c82333;
    }

</style>
</head>
<body>
<form action="CommonLoginServlet" method="post">
    <input type="hidden" name="action" value="ChangePassword">
    <table>
        <caption>Enter New Password </caption>

        <tr>
            <th>Change Password Type</th>
            <td>
                <select name="logintype" id="logintype" required>
                    <option value="">Select</option>
                    <option value="Admin">Admin</option>
                    <option value="Customer">Customer</option>
                </select>
            </td>
        </tr>

        <tr>
            <th>Email Id</th>
            <td><input type="email" name="EmailId" id="EmailId" placeholder="Enter Email Id" required></td>
        </tr>

        <tr>
            <th>Enter New Password</th>
            <td><input type="password" name="NewPassword" id="Password" placeholder="Enter Your New Password" required></td>
        </tr>
		<tr>
            <th>Confirm New Password</th>
            <td><input type="password" name="ConfirmPassword" id="Password" placeholder="Enter Your Confirm Password" required></td>
        </tr>
       

        <tr>
            <td><input type="submit" value="ChangePassword"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form>

</body>
</html>