<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>

form {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-size: 24px;
}

label {
    font-weight: bold;
    margin-top: 20px;
}

input[type="text"], input[type="password"] {
    margin-top: 20px;
    padding: 10px;
    font-size: 24px;
}

input[type="submit"] {
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #4CAF50; /* Green */
    color: white;
    border: none;
    cursor: pointer;
    font-size: 24px;
}

input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green */
}


</style>

<body>
	<form action="info?action=login" method="post">
	    <label for="username">Username:</label>
	    <input type="text" id="username" name="username">
	    <br>
	    <label for="password">Password:</label>
	    <input type="password" id="password" name="password">
	    <br>
	    <input type="submit" value="Login">
	    <a type="submit"  href="info?action=logout">Return</a>
	   
	</form>
</body>
</html>