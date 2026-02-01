<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}


body {
    background: #f0f4f8;
    margin: 0;
    padding: 0;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
      justify-content: center;
    align-items: center;
    background-image: url("images/Customerregister.png");
}


main {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}



.form-container {
    background: #ffffff;
    padding: 30px 40px;
    border-radius: 15px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 500px;
}

.form-container h2 {
    text-align: center;
    color: #2c3e50;
    margin-bottom: 25px;
}


.form-group {
    margin-bottom: 20px;
}

.form-group label {
    display: block;
    color: #34495e;
    font-weight: 600;
    margin-bottom: 8px;
}

.form-group input,
.form-group textarea {
    width: 100%;
    padding: 10px 12px;
    border: 1px solid #ccc;
    border-radius: 8px;
    font-size: 15px;
    transition: border-color 0.3s ease;
}

.form-group input:focus,
.form-group textarea:focus {
    border-color: #3498db;
    outline: none;
}


.form-buttons {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

.form-buttons input[type="submit"],
.form-buttons input[type="reset"] {
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.form-buttons input[type="submit"] {
    background-color: #3498db;
    color: white;
}

.form-buttons input[type="submit"]:hover {
    background-color: #2980b9;
}

.form-buttons input[type="reset"] {
    background-color: #e74c3c;
    color: white;
}

.form-buttons input[type="reset"]:hover {
    background-color: #c0392b;
}

</style>
</head>
<body >

<%String status = (String)request.getAttribute("RegisterCustomermsg");
 out.println(status);
%>

<div class="form-container">
    <h2>Customer Registration</h2>
    <form action="CommonCustomerServlet" method="post">
        <input type="hidden" name="action" value="addCust">

        <div class="form-group">
            <label for="custname">Customer Name</label>
            <input type="text" name="custname" id="custname" placeholder="Enter Your Name" required>
        </div>

        <div class="form-group">
            <label for="custemail">Email ID</label>
            <input type="email" name="custemail" id="custemail" placeholder="Enter Your Email Id" required>
        </div>

        <div class="form-group">
            <label for="custpass">Password</label>
            <input type="password" name="custpass" id="custpass" placeholder="Enter Your Password" required>
        </div>

        <div class="form-group">
            <label for="custadd">Address</label>
            <textarea name="custadd" id="custadd" rows="4" placeholder="Enter Your Address" required></textarea>
        </div>

        <div class="form-group">
            <label for="custcontact">Contact No</label>
            <input type="text" name="custcontact" id="custcontact" placeholder="Enter Your Contact No" required>
        </div>

        <div class="form-group">
            <label for="custloc">Location</label>
            <input type="text" name="custloc" id="custloc" placeholder="Enter Your Location" required>
        </div>

        <div class="form-buttons">
            <input type="submit" value="Register">
            <input type="reset" value="Cancel">
        </div>
    </form>
</div><br><br><br>
<jsp:include page="Footer.jsp" />
</body>

</html>
