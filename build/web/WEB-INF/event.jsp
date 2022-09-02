<%-- 
    Document   : event
    Created on : 10 mai 2022, 11:59:12
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evenement</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/styletheo.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/footer.css'/>">
    </head>
    <body>
        <c:forEach var="message" items="${requestScope.eventMessage}">
            <div class="${message.key}"><c:out value="${message.value}"/></div>
        </c:forEach>
        <!-- Ceci est un commentaire HTML visible dans le source de la page -->
        <%-- Ceci est un commentaire destiné aux développeurs, invisible dans le source de la page html --%>
        <%@include file="./jspf/header.jspf" %>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <%@include file="./jspf/sessionEmpty.jspf" %>
            </c:when>
            <c:otherwise>
                <%@include file="./jspf/main.jspf" %>
            </c:otherwise>
        </c:choose>
        
        <%@include file="./jspf/footer.jspf" %>
        <%@include file="./jspf/script.jspf" %>
    </body>
</html>
