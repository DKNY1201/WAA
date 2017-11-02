<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Advice</title>
</head>
<body>
	<c:choose>
		<c:when test="${user != null}">
			<h3>You are logged in as: ${ user.username }</h3>
			<h2>Ask for advice about your favorite roast:</h2>
			<p />
			<form action="advice" method="post">
				<select name="roast">
					<c:forEach var="roast" items="${roasts}">
						<option value="${roast.value}">${roast.value}</option>
					</c:forEach>
				</select>
				<p>
					<input type="submit" value="Submit" />
				</p>
			</form>
			
			<h3><a href="<spring:url value="/logout" />">Logout</a></h3>
		</c:when>
		<c:otherwise>
			<h3>You don't have authorization to access this page. Please <a href="<spring:url value="/" />">login</a> first</h3>
		</c:otherwise>
	</c:choose>
	

</body>
</html>