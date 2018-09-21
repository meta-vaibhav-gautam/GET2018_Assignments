<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.login-container {
	margin: 50px auto;
	width: 20%; 
	padding : 50px; 
	box-shadow : 5px 5px 5px grey;
	border-radius: 5px;
	padding: 50px;
	box-shadow: 5px 5px 5px grey;
	background-color: aliceblue;
}

#error-message {
	color:red;
	font-size: 20px;
}

#message {
	color:green;
	font-size: 20px;
}

form {
	background-color: lightgray;
	padding: 10px;
}

input[type=text],[type=password] {
	margin: 10px;
	padding: 5px;
    border-radius: 10px;
}
                                                                                                                                          
input[type=submit] {
	padding: 7px 25px;
    border-radius: 10px;
    background: deepskyblue;
}

h1 {
	text-align: center;
}
</style>
<title>Login</title>
</head>
<body>
	<div class="login-container">
		<h1>Login</h1>
		<c:if test="${not empty error}">
			<div id="error-message">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div id="message">${message}</div>
		</c:if>
		
		<form action="j_spring_security_check" method="post">
			<div>
				<label> Username: <input type="text" name="j_username"
					placeholder="Enter Username">
				</label>
			</div>
			<div>
				<label> Password: <input type="password" name="j_password"
					placeholder="Enter Password">
				</label>
			</div>
			<div>
				<input type="submit" value="login">
			</div>
		</form>

	</div>
</body>
</html>