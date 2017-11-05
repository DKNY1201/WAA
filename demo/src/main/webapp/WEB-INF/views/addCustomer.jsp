<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
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
				<p>Add Customers</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
			<fieldset>
				<legend>Add new Customer</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="customerId">Customer Id</label>
					<div class="col-lg-10">
						<form:input id="customerId" path="customerId" type="text" class="input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="address">Address</label>
					<div class="col-lg-10">
						<form:input id="address" path="address" type="text" class="input-large" />
						<form:input id="noOfOrdersMade" path="noOfOrdersMade" type="hidden" class="input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="role">Role</label>
					<div class="col-lg-10">
						<form:select id="role" path="role">
							<form:option value="user" label="User"/>
							<form:option value="admin" label="Admin"/>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>