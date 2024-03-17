<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/index_navbar.jsp" %>
<h1>SELLER LOGIN PAGE</h1>
	<form action="<%=request.getContextPath()%>/seller_login" method="post">
		<h1>${wrong}</h1>
		Enter Your Email:<br>
		<input type="text" name="email"><br><br>
		
		Enter Your Password:<br>
		<input type="text" name="password"><br><br>
		
		<input type="submit" value="Log In">
	
	</form>
</body>
</html>