<%-- 
    Document   : index.jsp
    Created on : Jun 29, 2021, 1:47:23 PM
    Author     : heaty566
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<form action="Send" method="POST">
			Email: <input name="email"/>
			message: <input name="message"/>
			<input type="submit" value="send"/>
		</form>
	</body>
</html>
