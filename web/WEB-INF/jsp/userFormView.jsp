<%-- 
    Document   : userFormView
    Created on : 2015-01-06, 16:43:18
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
    <body><spring:nestedPath path="person">
            <form action="" method="post">
                <span>Imię:</span>
                <spring:bind path="firstName">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
                <span>Nazwisko:</span>
                <spring:bind path="lastName">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
                <span>Adres:</span>
                <spring:bind path="address">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
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
                <input type="submit" value="Zarejestruj">
            </form>
        </spring:nestedPath>
    </body>
</html>
