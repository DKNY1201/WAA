<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,
initial-scale=1">
<title>Calculator</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${errors != null}">

		<p id="errors">Error(s)!
		<ul>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
		</ul>
	</c:if>

	<form action="handleCalc" method="post">
		<fieldset>
			<legend>Calculator</legend>

			<input name="add1" type="text" size="2" value="${calculator.add1}" />+
			<input name="add2" type="text" size="2" value="${calculator.add2}" />=
			<input name="sum" type="text" size="4" value="${calculator.sum }"
				readonly /> <br> <input name="mult1" type="text" size="2"
				value="${calculator.mult1}" />* <input name="mult2" type="text"
				size="2" value="${calculator.mult2}" />= <input name="product"
				type="text" size="4" readonly /> <br> <input type="submit"
				value="Submit" />
		</fieldset>
	</form>
</body>
</html>