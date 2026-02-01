<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.FoodPlaza.pojo.Cart"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart List</title>
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
}

table {
    width: 90%;
    margin: 30px auto;
    border-collapse: collapse;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    background-color: #ffffff;
    border-radius: 12px;
    overflow: hidden;
}

th, td {
    padding: 14px 20px;
    text-align: center;
    border-bottom: 1px solid #e0e0e0;
    font-size: 16px;
}

th {
    background-color: #28a745;
    color: #fff;
    font-size: 18px;
    text-transform: uppercase;
}

tr:hover {
    background-color: #f1f1f1;
}

tr:last-child td {
    font-weight: bold;
    background-color: #f0f8ff;
}

input[type="number"] {
    padding: 5px;
    width: 60px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* Update Button */
input[type="submit"].btn-update {
    padding: 6px 14px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    margin: 4px;
}

input[type="submit"].btn-update:hover {
    background-color: #0056b3;
}


input[type="submit"].btn-delete {
    padding: 6px 14px;
    background-color: #dc3545;
    color: #fff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    margin: 4px;
}

input[type="submit"].btn-delete:hover {
    background-color: #c82333;
}

/* Place Order Button */
.place-order-btn {
    background-color: green;
    color: white;
    font-size: 18px;
    padding: 12px 30px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
}

.place-order-btn:hover {
    background-color: #0b6623;
}

.status-message {
    width: 90%;
    margin: 20px auto;
    padding: 12px;
    background-color: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
    border-radius: 5px;
    font-size: 16px;
}

@media (max-width: 768px) {
    table {
        width: 95%;
        font-size: 14px;
    }

    th, td {
        padding: 8px;
    }

    input[type="submit"], .place-order-btn {
        padding: 5px 10px;
        font-size: 12px;
    }

    .status-message {
        font-size: 14px;
    }
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp" />

	<%
    String[] Status = { 
        (String) request.getAttribute("DeleteCart"),
        (String) request.getAttribute("NotDeleteCart"), 
        (String) request.getAttribute("UpdateCart"), 
        (String) request.getAttribute("NotUpdateCart"),
        (String) request.getAttribute("OrderPlaced"),
        (String) request.getAttribute("OrderFailed")
    }; 
    for (String msg : Status) {
        if (msg != null) {
    %>
        <div class="status-message"><%=msg%></div>
    <%
        }
    }
    %>

	<%
	List<Cart> cli = (List<Cart>) request.getAttribute("CartList");
	double grandTotal = 0;
    %>

	<%
	if (cli != null && !cli.isEmpty()) {
	%>
	<table>
		<tr>
			<th>Cart Id</th>
			<th>Food Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total Price</th>
		</tr>
		<%
		for (Cart c : cli) {
			grandTotal += c.getTotalprice();
		%>
		<tr>
			<td><%=c.getCartId()%></td>
			<td><%=c.getFoodname()%></td>
			<td><%=c.getFoodprice()%></td>
			<td>
				<form action="CommonCartServlet" method="get" style="display:inline;">
					<input type="hidden" name="action" value="edit" />
					<input type="hidden" name="CartId" value="<%=c.getCartId()%>" />
					<input type="number" name="CartQun" value="<%=c.getFoodquantity()%>" min="1" required />
					<input type="submit" value="Update" class="btn-update" />
				</form>

				<form action="CommonCartServlet" method="get" style="display:inline;">
					<input type="hidden" name="action" value="delete" />
					<input type="hidden" name="CartId" value="<%=c.getCartId()%>" />
					<input type="submit" value="Delete" class="btn-delete" />
				</form>
			</td>
			<td><%=c.getTotalprice()%></td>
		</tr>
		<% } %>
		<tr>
			<td colspan="4" style="text-align: right; font-weight: bold;">Grand Total</td>
			<td><%= grandTotal %></td>
		</tr>
	</table>

	
	<div style="text-align: center; margin-top: 20px;">
		<form action="CommonCartServlet" method="get">
			<input type="hidden" name="action" value="placeorder" />
			<input type="submit" value="Place Order" class="place-order-btn" />
		</form>
	</div>

	<%
	} else {
	%>
		<div class="status-message" style="text-align:center;">Your cart is empty.</div>
	<%
	}
	%>

	<jsp:include page="Footer.jsp" />
</body>
</html>