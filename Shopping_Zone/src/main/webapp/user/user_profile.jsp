<%@page import="com.org.daoImpl.UserDaoImpl"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/user_navbar.jsp" %>
<%
	int id=(int)session.getAttribute("userId");
	UserDaoImpl userdao=new UserDaoImpl();
	User user=userdao.fetchUserById(id);
%>
<h1></h1>
<h1><%=user.getName()%> Details</h1>
<h1>Mobile:-<%=user.getMobile()%> </h1>
<h1>Email:-<%=user.getEmail()%> </h1>
<h1>Address:-<%=user.getAddress()%></h1>

</body>
</html>