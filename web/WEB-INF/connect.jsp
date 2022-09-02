<%-- 
    Document   : connect
    Created on : 25 avr. 2022, 15:40:57
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/login.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/footer.css'/>">
    </head>
    <body>
        <c:forEach var="message" items="${requestScope.registerMessage}">
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
                <%--<h2>Voici nos Evenement</h2>
                <c:forEach var="event" items="${requestScope.events}" varStatus="status">
                    <article>
                        <h3>${status.count}. ${pageScope.event.title}</h3>
                        <div>evenement créé le ${pageScope.event.date}</div>

                    </article>
                </c:forEach>--%>
            </c:otherwise>
        </c:choose>
        <%@include file="./jspf/footer.jspf" %>
        <%@include file="./jspf/script.jspf" %>
    </body>
</html>

