<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register page</title>
</head>
<body>
<h1>Register Form</h1>
<form method="POST" action="register">
    <div>
        <label for="email">Accountant Email:</label>
        <p class="error">${error}</p>
        <input type="text" name="email" id="email" required>
    </div>
    <div>
        <label for="username">Username:</label>
        <p class="error">${error1}</p>
        <input type="text" name="username" id="username" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required>
    </div>
    <label for="role">Role:</label>
    <input type="text" name="role" value="accountant" readonly="true"></br>
   <input type="submit" value="Register"/>
</form>


</body>
</html>