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
	<p style="font-weight:bold;">Update User Profile</p>
	
	<form action="FrontController" method="post">
	<table style="border: none;">
		 <tr>
             <td> ID  : </td>
             <td><c:out value="${user.id}"/></td>
         </tr>
		 <tr>
             <td> User Name  : </td>
             <td> <input name="username" size=15 type="text" value="${user.username}" /> </td>
         </tr>
         <tr>
             <td> First Name  : </td>
             <td> <input name="firstname" size=15 type="text" value="${user.firstName}" /> </td> 
         </tr>
         <tr>
             <td> Last Name  : </td>
             <td> <input name="lastname" size=15 type="text" value="${user.lastName}" /> </td> 
         </tr>
         <tr>
             <td> Password  : </td>
             <td> <input name="password" size=15 type="password" value="${user.password}" /> </td> 
         </tr>
         <tr>
             <td> Repeat Password  : </td>
             <td> <input name="rePassword" size=15 type="password" /> </td> 
         </tr>
		<tr>
			<td colspan="2">
				<input type="hidden" name="action" value="SaveUserProfile" />
		        <input type="submit" value="Save" />
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>