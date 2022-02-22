<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove?</title>
</head>

<body>
	<p>You only have one of this book. Would you like to <b>remove</b> it?</p>
	
	<br/><br/>
	<c:set var="user_bookID" value="${sessionScope.user_bookID}"/>
    <form action="FrontController" method="post">
		<input type="hidden" name="action" value="RemoveBook" />
		<input name="bookid" size=15 type="hidden" value="${user_bookID}"/>
		<input type="submit" value="Yes" />
	</form>
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="MyBooks" />
         <input type="submit" value="No" />
    </form>
		
</body>

</html>