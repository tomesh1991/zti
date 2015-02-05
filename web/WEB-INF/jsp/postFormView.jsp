<%-- 
    Document   : postFormView
    Created on : 2015-02-05, 09:34:49
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
        <spring:nestedPath path="post">
            <form action="" method="post">
                <span>Tekst:</span>
                <spring:bind path="textContent">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
                <span>Dodaj zdjęcie z internetu:</span>
                <spring:bind path="URL">
                    <input type="text" name="${status.expression}" value="${status.value}">
                </spring:bind>
                <br />
                <input type="submit" value="Zarejestruj">
            </form>
        </spring:nestedPath>
    </body>
</html>
