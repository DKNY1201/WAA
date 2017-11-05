<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right:50px">
			<a href="?language=en" >English</a> | 
			<a href="?language=nl" >Dutch</a> | 
			<a href="<c:url value="/logout" />">Logout</a>
		</div>
	</section>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
				<p>All the available Customers in our store</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-6 col-md-3" style="paddingbottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${customer.name}</h3>
							<p>${customer.address}</p>
							<p>This customer ordered ${customer.noOfOrdersMade} order(s)</p>
							<p>Role: ${customer.role}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>