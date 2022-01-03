<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin product update</title>
</head>
<body>
<h2>product update</h2>
<form action="updateitemservlet" method="get">
	Enter product name:<br>
	<input type="text" name="proname" id="proname"><br>
	Enter product quantity:<br>
	<input type="number" name="quantity" id="quantity"><br>
	
	<button type="submit">update  quantity</button>
	
</form>
</body>
</html>