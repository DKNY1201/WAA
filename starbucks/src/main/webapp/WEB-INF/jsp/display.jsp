<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffees</title>
</head>
<body>
	<c:choose>
		<c:when test="${user != null}">
		<h3>You are logged in as: ${ user.username }</h3>
		<h2>Starbuck's ${param["roast"]} Roast Coffees:</h2>
		<form action="advice" method="get">
			<table>
				<c:forEach var="coffee" items="${coffees}" varStatus="status">
					<c:choose>
						<c:when test="${(status.index)%2 eq 0}">
							<tr style="background-color: cyan">
						</c:when>
						<c:otherwise>
							<tr style="background-color: yellow">
						</c:otherwise>
					</c:choose>
					<td>${coffee}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Back">
		</form>
		<h3><a href="<spring:url value="/logout" />">Logout</a></h3>
		</c:when>
		<c:otherwise>
			<h3>You don't have authorization to access this page. Please <a href="<spring:url value="/" />">login</a> first</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>