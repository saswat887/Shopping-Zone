<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.daoImpl.SellerDaoImpl"%>
<%@page import="com.org.dao.SellerDao"%>
<%@page import="com.org.dto.Seller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="seller_login.jsp" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../components/allcss.jsp" %>
</head>
<body>
<%@include file="../components/seller_navbar.jsp" %>

<%
	int sellerId=(int)session.getAttribute("sellerId");
	Seller seller=new SellerDaoImpl().fetchSellerById(sellerId);
	List<Product> products=seller.getProducts();
%>
<h1>PRODUCT LIST</h1>
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
		<td><a href="<%=request.getContextPath()%>/update_product?productId=${p.getId()}">Update</a></td>
		<td><a href="<%=request.getContextPath()%>/delete_product?productId=${p.getId()}">Delete</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>