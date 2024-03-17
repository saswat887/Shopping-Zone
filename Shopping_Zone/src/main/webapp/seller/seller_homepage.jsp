<%@page import="com.org.dto.Seller"%>
<%@page import="com.org.daoImpl.SellerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="seller_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/seller_navbar.jsp" %>
<%
	int id=(int)session.getAttribute("sellerId");
	SellerDaoImpl sellerdao=new SellerDaoImpl();
	Seller user=sellerdao.fetchSellerById(id);
%>
<h1>Seller Details</h1>
<h1>Name<%=user.getName()%></h1>
<h1>Mobile:-<%=user.getMobile()%> </h1>
<h1>Email:-<%=user.getEmail()%> </h1>
<h1>Address:-<%=user.getAddress()%></h1>

</body>
</html>