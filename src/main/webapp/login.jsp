<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:set var="username" value="${sessionScope.registerUsername}"/>
<c:set var="password" value="${sessionScope.registerPassword}"/>
			<form action="FrontController" method="post">
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" value="${username}" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="password" value="${password}" /> </td> 
                    </tr>
                </table>
                
                <input type="hidden" name="action" value="LoginUser" />
                <input type="submit" value="login" />
            </form>
</body>
</html>