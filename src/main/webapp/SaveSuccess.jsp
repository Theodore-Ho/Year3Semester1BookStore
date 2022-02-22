<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Basket Successful</title>
</head>
<body>
	<p>Add to Basket successful!</p>
	<form action="FrontController" method="post">
	     <input type="hidden" name="action" value="MyBooks" />
         <input type="submit" value="My Basket" />
    </form>
</body>
</html>