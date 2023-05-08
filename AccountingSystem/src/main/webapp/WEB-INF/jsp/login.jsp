<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Form</title>
</head>
<body>
	<h1>Login Form</h1>
	<form method="post" action="login">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required><br><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required><br><br>
		<label for="role">Select Role:</label>
		<select id="role" name="role">
			<option value="admin">Admin</option>
			<option value="accountant">Accountant</option>
		</select><br><br>
		<input type="submit" value="Login">
		  <p class="error">${error}</p>
	</form>
</body>
</html>