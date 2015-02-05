<%-- 
    Document   : postSuccessView
    Created on : 2015-02-05, 09:33:03
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
        <h1>${postMessage}</h1>
    </body>
</html>
