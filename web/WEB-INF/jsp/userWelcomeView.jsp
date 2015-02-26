<%-- 
    Document   : userWelcomeView
    Created on : 2015-01-06, 16:42:04
    Author     : Klotor90
--%>

<%@page import="bean.LoggedUser"%>
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
            <a href="<c:url value="/main.htm" />">Główna</a><br>   
            <a href="<c:url value="/register.htm" />">Rejestracja</a><br>           
            <a href="<c:url value="/login.htm" />">Logowanie</a><br>    
            <a href="<c:url value="/post.htm" />">Posty</a><br>
            <a href="<c:url value="/admin.htm" />">Panel</a><br>
            <a href="<c:url value="/logout.htm" />">Wyloguj</a><br>
        </div>

        <div id="section">
            <h1>${welcomeMessage}</h1>
        </div>

        <div id="footer">
            Zalogowany jako 
            <%
            out.println(LoggedUser.getLoggedUser());
            %>
        </div>
    </body>
</html>
