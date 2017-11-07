<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="employee.addemployeeform" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
</head>
<body>
	<div class="language">
		<a href="?language=en">ENG</a> | <a href="?language=vn">VN</a>
	</div>
	<div id="global">
		<form:form commandName="employee" action="employee_save" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend><spring:message code="employee.addanemployee" /></legend>
				<p>
					<form:errors path="*" cssStyle="color : red;" />
				</p>
				<p>
					<label for="id"><spring:message code="employee.id" />: </label>
					<form:input path="id" id="id" />
					<div style="text-align: center;">
						<form:errors path="id" cssStyle="color : red;" />
					</div>
				</p>
				<p>
					<label for="firstName"><spring:message code="employee.firstName" />: </label>
					<form:input path="firstName" />
					<div style="text-align: center;">
						<form:errors path="firstName" cssStyle="color : red;" />
					</div>
				</p>
				<p>
					<label for="lastName"><spring:message code="employee.lastName" />: </label>
					<form:input path="lastName" />
					<div style="text-align: center;">
						<form:errors path="lastName" cssStyle="color : red;" />
					</div>
				</p>

				<p>
					<label for="birthDate"><spring:message code="employee.dateOfBirth" />: </label>
					<form:input path="birthDate" id="birthDate" />
					<form:errors path="birthDate" cssStyle="color : red;" />
				</p>
				<p>
					<label for="salaryLevel"><spring:message code="employee.salaryLevel" />: </label>
					<form:input path="salaryLevel" id="salaryLevel" />
					<div style="text-align: center;">
						<form:errors path="salaryLevel" cssStyle="color : red;" />
					</div>
				</p>
				<h4><spring:message code="employee.address" />:</h4>
				<p>
					<label for="street"><spring:message code="employee.address.street" />: </label>
					<form:input path="address.street" id="street" />
					<div style="text-align: center;">
						<form:errors path="address.street" cssStyle="color : red;" />
					</div>
				</p>
				<p>
					<label for="state"><spring:message code="employee.address.state" />: </label>
					<form:input path="address.state" id="state" />
					<div style="text-align: center;">
						<form:errors path="address.state" cssStyle="color : red; " />
					</div>
				</p>
				<p>
					<label for="zipCode"><spring:message code="employee.address.zip" />: </label>
					<form:input path="address.zipCode" id="zipCode" />
					<div style="text-align: center;">
						<form:errors path="address.zipCode" cssStyle="color : red; " />
					</div>
				</p>
				<p>
					<label for="image"><spring:message code="employee.image" />: </label>
					<form:input path="image" id="image" type="file" />
					<div style="text-align: center;">
						<form:errors path="image" cssStyle="color : red; " />
					</div>
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> 
					<input id="submit" type="submit" tabindex="5" value="<spring:message code="employee.addemployee" />">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
