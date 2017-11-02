 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
<form:form modelAttribute="newProduct" action="product" method="post">
    <fieldset>
        <legend><spring:message code="product.addproduct" text="Add a product" /></legend>
        <p>
            <label for="category"><spring:message code="product.category" text="Category" /></label>
 		 	<form:select id="category" path="category.id">
 		 		<%-- <spring:message code='product.selectcategory' text='--Select Category--' /> --%>
			    	<form:option value="0" label="--Select Category--" />
				<form:options items="${categories}" itemLabel="name" itemValue="id" />
		    </form:select>
        </p>
         
        <p>
            <label for="name"><spring:message code="product.productname" text="Product Name: " /></label>
            <form:input type="text" id="name" path="name" tabindex="1" />
        </p>
        <p>
            <label for="description"><spring:message code="product.description" text="Description: " /></label>
            <form:input type="text" id="description" path="description" tabindex="2" />
        </p>
        <p>
            <label for="price"><spring:message code="product.price" text="Price: " /></label>
            <form:input type="text" id="price" path="price" tabindex="3" />
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="<spring:message code="product.addproduct" text="Add Product" />">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
