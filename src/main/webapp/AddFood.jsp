<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Food</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	display: flex;
	flex-direction: column;
}


.page-wrapper {
	flex: 1;
	display: flex;
	align-items: center;
	justify-content: center;
	background-image: url("images/AddFood.png");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}


.container {
	max-width: 500px;
	width: 100%;
	padding: 40px;
	background-color: rgba(255, 255, 255, 0.95);
	border-radius: 15px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}


h2 {
	text-align: center;
	margin-bottom: 25px;
	color: #dc3545;
	font-weight: 600;
}


.btn-primary {
	background-color: #dc3545;
	border: none;
	font-weight: bold;
}

.btn-primary:hover {
	background-color: #c82333;
}


footer {
	margin-top: auto;
}
</style>
</head>

<body>

	
	
	<div class="page-wrapper">
		<div class="container">
			<h2>Add New Food Item</h2>
			<form action="CommonFoodServlet" method="post">
				<input type="hidden" name="action" value="add" />

				<div class="mb-3">
					<label for="foodName" class="form-label">Food Name</label>
					<input type="text" class="form-control" id="foodName" name="foodName" required>
				</div>

				<div class="mb-3">
					<label for="foodCategory" class="form-label">Category</label>
					<select class="form-select" name="foodCategory" required>
						<option value="">-- Select Category --</option>
						<option value="Starter">Starter</option>
						<option value="Main Course">Main Course</option>
						<option value="Dessert">Dessert</option>
						<option value="Beverage">Beverage</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="foodType" class="form-label">Food Type</label>
					<select class="form-select" id="foodType" name="foodType" required>
						<option value="">-- Select --</option>
						<option value="Veg">Veg</option>
						<option value="Non-Veg">Non-Veg</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="foodPrice" class="form-label">Food Price</label>
					<input type="number" step="0.01" class="form-control" id="foodPrice" name="foodPrice" required>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-primary">Add Food</button>
				</div>
			</form>
		</div>
	</div>

	
	
</body>
</html>
