<%-- 
    Document   : loginFormView
    Created on : 2015-01-06, 16:46:48
    Author     : Klotor90
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/style.css" />">
    </head>
    <body>
        <div id="header">
            <h1>City Gallery</h1>
        </div>

        <div id="nav">
            London<br>
            Paris<br>
            Tokyo<br>
        </div>

        <div id="section">
            <spring:nestedPath path="user">
                <form action="" method="post">
                    <span>Login:</span>
                    <spring:bind path="userLogin">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <br />
                    <span>Hasło:</span>
                    <spring:bind path="password">
                        <input type="password" name="${status.expression}"
                               value="${status.value}">
                    </spring:bind>
                    <br />
                    <input type="submit" value="Zaloguj">
                </form>
            </spring:nestedPath>
        </div>

        <div id="footer">
            Copyright Š W3Schools.com
        </div>
    </body>
</html>
