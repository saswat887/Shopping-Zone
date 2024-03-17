<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="seller_login.jsp" isELIgnored="false"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/seller_navbar.jsp" %>
<h1>ADD PRODUCT PAGE</h1>
<h2>${success}</h2>
<form:form action="${pageContext.request.contextPath}/add_product" method="post" modelAttribute="product">
	Enter Product Name:<br>
	<form:input path="name"/><br><br>
	
	Enter Product Price:<br>
	<form:input path="price"/><br><br>
	
	Enter Product Category:<br>
	<form:input path="category"/><br><br>
	
	Enter Product Description:<br>
	<form:input path="description"/><br><br>
	
	Enter Quantity:<br>
	<form:input path="stockLeft"/><br><br>
	<form:hidden path="id"/>
	
	<form:button>Submit</form:button>


</form:form>
</body>
</html>