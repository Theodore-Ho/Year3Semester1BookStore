<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Basket</title>
<script>
function displayInfo() {
	alert("Check out successful!");
}
</script>
</head>
<body>
<table style="border:none">
	<tr>
		<th style="text-align: center; width: 800px;">Title</th>
		<th style="text-align: center;">Unit Price</th>
		<th></th>
		<th style="text-align: center;">Quantity</th>
		<th></th>
		<th></th>
	</tr>
<c:forEach var="item" items="${books}">
	<tr style="height: 50px;">
		<td>${item.title}</td>
		<td style="text-align: center;">€ ${item.price}</td>
		<td>
			<form action="FrontController" method="post">
				<input type="hidden" name="action" value="MinusOne" />
				<input name="bookid" size=15 type="hidden" value="${item.id}"/>
				<input type="submit" value="-" />
			</form>
		</td>
		<td style="text-align: center;">${item.quantity}</td>
		<td>
			<form action="FrontController" method="post">
				<input type="hidden" name="action" value="AddOne" />
				<input name="bookid" size=15 type="hidden" value="${item.id}"/>
				<input type="submit" value="+" />
			</form>
		</td>
		<td>
			<form action="FrontController" method="post">
				<input type="hidden" name="action" value="RemoveBook" />
				<input name="bookid" size=15 type="hidden" value="${item.id}"/>
				<input type="submit" value="Remove" />
			</form>
		</td>
	</tr>
</c:forEach>
<c:set var="totalPrice" value="${sessionScope.totalPrice}"/>
	<tr>
		<td colspan="6" style="text-align: right; font-size: 20px;">Total price: € ${totalPrice}</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: right;">
			<form action="FrontController" method="post">
			  	<input type="hidden" name="action" value="BackMenu" />
			    <input type="submit" value="Menu" />
			</form>
		</td>
		<td style="text-align: right;">
			<form action="FrontController" method="post">
			  	<input type="hidden" name="action" value="CheckOut" />
			    <input type="submit" value="Check Out" onclick="displayInfo()"/>
			</form>
		</td>
	</tr>
</table>
</body>
</html>