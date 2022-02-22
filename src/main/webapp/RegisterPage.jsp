<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
			<form action="FrontController" method="post">
                <table>
                	<tr>
                        <td> First Name  : </td><td> <input name="firstname" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Last Name  : </td><td> <input name="lastname" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> User Name  : </td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="password" /> </td> 
                    </tr>
                    <tr>
                        <td> Password Repeat  : </td><td> <input name="passwordRe" size=15 type="password" /> </td> 
                    </tr>
                </table>
                
                <input type="hidden" name="action" value="RegisterUser" />
		        <input type="submit" value="Register" />
            </form>
</body>
</html>