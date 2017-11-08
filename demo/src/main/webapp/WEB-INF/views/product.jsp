<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<script src="https://ajax.googleapis.com/ajax
/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="/demo/resources/js/controllers.js"></script>
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
		<div class="pull-right" style="padding-right:50px">
			<a href="${currentUrl}&language=en" >English</a> | <a href="${currentUrl}&language=nl" >Dutch</a>
		</div>
	</section>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
			<div class="col-md-5">
				<img src="<c:url value="/img/${product.productId}.jpg"></c:url>" alt="image" style = "width:100%"/>
			</div>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong><spring:message code="product.itemcode.label" /> : </strong>
					<span class="label label warning">${product.productId}</span>
				</p>
				<p>
					<strong><spring:message code="product.manufacturer.label" /></strong> : ${product.manufacturer}
				</p>
				<p>
					<strong><spring:message code="product.category.label" /></strong> : ${product.category}
				</p>
				<p>
					<strong><spring:message code="product.availableUnitInStock.label" /> </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}USD</h4>
				<p><a href="<c:url value="/pdf/${product.productId}.pdf"></c:url>"><spring:message code="product.downloadManual.label" /></strong></a></p>
				<p ng-controller="cartCtrl">
					<a href="<spring:url value="/market/products" />" class="btn btn-default"> 
						<span class="glyphicon-hand-left glyphicon"></span> <spring:message code="product.back.label" /></strong>
					</a> 
					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"> 
						<span class="glyphicon-shopping-cart glyphicon"> </span> <spring:message code="product.orderNow.label" /></strong>
					</a>
					<a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span> View Cart
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>