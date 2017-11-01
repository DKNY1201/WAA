<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator Application</title>
<style>
	#errors {
		color: red;
	}
</style>
</head>
<body>
	<c:if test="${errors != null}">
		<div id="errors">
			<h3>Error(s)!</h3>
			<ul>
				<c:forEach var="error" items="${errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<form action="result" method="post">
		<input type="text" name="add1" size="2" value="${calc.add1}" />+ 
		<input type="text" name="add2" value="${calc.add2}" size="2" />=
		<input type="text" name="" value="" size="2" readonly /><br /> 
		<input type="text" name="mult1" value="${calc.mult1}" size="2" />* 
		<input type="text" name="mult2" value="${calc.mult2}" size="2" />=
		<input type="text" name="" value="" size="2" readonly /><br /> 
		<input type="submit" value="Submit" />
	</form>
</body>
</html>