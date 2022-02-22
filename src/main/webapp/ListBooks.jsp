<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Books</title>
</head>
<body>
<table style="border:none">
	<tr>
		<th>Author</th>
		<th>Title</th>
		<th>Publisher</th>
		<th>Year</th>
		<th>ISBN</th>
		<th>Price</th>
		<th></th>
	</tr>
<c:forEach var="item" items="${books}">
	<tr style="height: 50px;">
		<td>${item.author}</td>
		<td>${item.title}</td>
		<td>${item.publisher}</td>
		<td>${item.year}</td>
		<td>${item.isbn}</td>
		<td>${item.price}</td>
		<td>
			<form action="FrontController" method="post">
				<input type="hidden" name="action" value="SaveBook" />
				<input name="bookid" size=15 type="hidden" value="${item.id}"/>
				<input type="submit" value="Add Basket" />
			</form>
		</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="6" style="text-align: right;">
			<form action="FrontController" method="post">
			     <input type="hidden" name="action" value="MyBooks" />
		         <input type="submit" value="My Basket" />
		    </form>
		</td>
		<td style="text-align: right;">
			<form action="FrontController" method="post">
			  	<input type="hidden" name="action" value="BackMenu" />
			    <input type="submit" value="Menu" />
			</form>
		</td>
	</tr>
</table>
</body>
</html>