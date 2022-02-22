<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<c:set var="user" value="${sessionScope.user}"/>
	<p style="font-weight:bold;">View Profile for: <c:out value="${user.username}"/></p>
	<table style="border: none;">
		<tr>
			<td>ID:</td>
			<td><c:out value="${user.id}"/></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><c:out value="${user.firstName}"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><c:out value="${user.lastName}"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><c:out value="${user.password}"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="FrontController" method="post">
					<input type="hidden" name="action" value="UpdateUserProfile" />
					<input name="userid" size=15 type="hidden" value="${user.id}"/>
					<input type="submit" value="Update" />
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="FrontController" method="post">
					<input type="hidden" name="action" value="BackMenu" />
			    	<input type="submit" value="Menu" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>