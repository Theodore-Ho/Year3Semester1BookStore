<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Book</title>
</head>
<body>
	<form action="FrontController" method="post">
	    <table>
	        <tr>
	            <td> Search title  : </td><td> <input name="search_input" size=15 type="text" /> </td> 
	        </tr>
	    </table>
	    
	    <input type="hidden" name="action" value="SearchBook" />
	    <input type="submit" value="Search" />
	</form>
</body>
</html>