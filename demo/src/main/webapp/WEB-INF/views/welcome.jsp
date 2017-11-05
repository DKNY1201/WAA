<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,
initial-scale=1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/
bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right:50px">
			<a href="?language=en" >English</a> | 
			<a href="?language=nl" >Dutch</a> | 
			<a href="<c:url value="/logout" />">Logout</a>
		</div>
	</section>
	<div class="jumbotron">
		<h1>${greeting}</h1>
		<p>${tagline}</p>
	</div>
</body>
</html>