<%-- 
    Document   : login
    Created on : Jul 1, 2021, 9:22:39 AM
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
                <form action="LoginController" method="POST">
                        <font color='red' > ${requestScope.errorMessage}</font>
                        <br/>
                        Username: <input type="text" name="username" value="${param.username}" />
                        <font color='red' > ${requestScope.usernameError}</font>
                        <br/>
                        Password: <input type="password" name="password" value="${params.password}" />
                        <font color='red' > ${requestScope.passwordError}</font>
                        <br/>
                        <input type="submit" value="Login" />
                </form>
        </body>
</html>
