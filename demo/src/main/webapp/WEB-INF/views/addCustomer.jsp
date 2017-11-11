<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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