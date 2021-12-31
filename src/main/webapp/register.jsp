<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="Login1" method="post">
			<label>Name:</label>
			<input type="text" id="userName" name="userName" placeholder="Enter your user name" autofocus
				required /><br><br>
			<div>
				
				<label>Address:</label>
				<input type="text area" id="address" name="address" placeholder="Enter your address" required /><br />
				<br>
				<label>Email:</label>
				<input type="email" id="email" name="email" placeholder="Enter your email" required /><br /> <br>
				<label>Password:</label>
				<input type="password" id="password" name="password" placeholder="Enter your password"
					required /><br /><br>
				<label>Mobile number:</label> <input type="text" id="mobileNumber" name="mobileNumber"
					placeholder="Enter your mobile number" required /><br /><br>
				
				
				<button type="submit">Submit</button>
		</form>
</body>
</html>