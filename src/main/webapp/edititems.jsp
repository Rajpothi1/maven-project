<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin operations</title>
</head>
<body>
	<h2>Add item</h2>
	<form action="additemservlet" method="post">
	Enter product name:<br>
	<input type="text" name="proname" id="proname"><br>
	Enter product quantity:<br>
	<input type="number" name="quantity" id="quantity"><br>
	Enter product price:<br>
	<input type="text" name="price" id="price"><br>
	<button type="submit">Add item</button>
	</form>
</body>
</html>