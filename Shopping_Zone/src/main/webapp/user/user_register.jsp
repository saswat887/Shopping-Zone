<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
<%@include file="../components/allcss.jsp" %>
</head>
<body>
<%@include file="../components/index_navbar.jsp" %>
<h1>User Register</h1>
<h1>Seller Sign Up</h1>
<form:form action="register_user" method="post" modelAttribute="user">
	Enter Your Name:<br>
	<form:input path="name"/><br><br>
	
	Enter Your Mobile:<br>
	<form:input path="mobile"/><br><br>
	
	Enter Your Email:<br>
	<form:input path="email"/><br><br>
	
	Enter Your Password:<br>
	<form:password path="password"/><br><br>
	
	Enter Your Address:<br>
	<form:textarea path="address" rows="5" cols="20"/><br><br>
	
	<form:button>Submit</form:button>

</form:form>
</body>
</html>