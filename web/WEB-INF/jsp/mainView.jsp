<%-- 
    Document   : mainView
    Created on : 2015-02-05, 12:20:52
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
            <a href="<c:url value="/main.htm" />">Główna</a><br>   
            <a href="<c:url value="/register.htm" />">Rejestracja</a><br>           
            <a href="<c:url value="/login.htm" />">Logowanie</a><br>
            Coś tu będzie<br>
        </div>

        <div id="section">
            Strona w konstrukszyn, przyjdź Pan jutro.
        </div>

        <div id="footer">
            Copyright Skórewicz & Juszkiewicz
        </div>
    </body>
</html>