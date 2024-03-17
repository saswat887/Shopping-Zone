<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.daoImpl.ProductDaoImpl"%>
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
<center>
<h1>User Home Page</h1>
<%
	ProductDaoImpl dao=new ProductDaoImpl();
	List<Product> products=dao.fetchAllProduct();
%>
<table style="border: 2px solid black;">
<tr>
	<th>Name</th>
	<th>Price</th>
	<th>Category</th>
	<th>Description</th>
	<th>Stock Left</th>
	<th>Action</th>
	<th>Action</th>

</tr>
<c:forEach var="p" items="<%=products%>">
	<tr>
		<td>${p.getName()}</td>
		<td>${p.getPrice()}</td>
		<td>${p.getCategory()}</td>
		<td>${p.getDescription()}</td>
		<td>${p.getStockLeft()}</td>
		<td><a href="<%=request.getContextPath()%>/add_item?productId=${p.getId()}">Add To Cart</a></td>
		<td><a href="">Buy Now</a></td>
	</tr>
</c:forEach>
</center>
</body>
</html>