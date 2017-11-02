<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
#errors {
	color: red;
}
</style>
</head>
<body>
	<c:if test="${error != null}">
		<div id="errors">
			<p>Error!</p>
			<p>${error}</p>
		</div>
	</c:if>

	<form action="login" method="post">

		<p>Login:</p>
		<p>
			Name : <input type="text" id="username" name="username" />
		</p>
		<p>
			Password : <input type="password" id="password" name="password" />
		</p>
		<p>
			<input type="submit" value="login" />
		</p>
	</form>
</body>
</html>