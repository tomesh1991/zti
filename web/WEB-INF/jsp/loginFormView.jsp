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
            <h1>Plotki ploteczki</h1>
        </div>

        <div id="nav">
            <a href="<c:url value="/register.htm" />">Rejestracja</a><br>           
            <a href="<c:url value="/login.htm" />">Logowanie</a><br>
            Coś tu będzie<br>
        </div>

        <div id="section">
            
            <spring:nestedPath path="user">
                <form action="" method="post">
                    <table>
                        <tr>
                            <td><span>Login:</span></td>
                    <spring:bind path="userLogin">
                        <td><input type="text" name="${status.expression}" value="${status.value}"></td>
                    </spring:bind>
                        </tr>
                        <tr>
                    <td><span>Hasło:</span></td>
                    <spring:bind path="password">
                        <td><input type="password" name="${status.expression}"
                               value="${status.value}"></td>
                    </spring:bind>
                        </tr>
                        <tr>
                    <td><input type="submit" value="Zaloguj"></td>
                    </tr>
                    </table>
                </form>
            </spring:nestedPath>
        </div>

        <div id="footer">
            Copyright Skórewicz & Juszkiewicz
        </div>
    </body>
</html>
