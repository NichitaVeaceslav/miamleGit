<%--
    Document   : connect
    Created on : 25 avr. 2022, 15:38:57
    Author     : Herbert Caffarel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/styletheo.css'/>">
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
                <main>
                    <form action="" method="post">
                        <fieldset>
                            <legend>Inscription</legend>
                            <div>
                                <label for="name">Votre courriel<span class="required">*</span></label>
                                <input type="text" id="email" name="email" value="<c:out value="${requestScope.user.email}"/>">
                                <span class="error">${requestScope.errors.email}</span>
                            </div>
                            <div>
                                <label for="pwd">Votre mot de passe<span class="required">*</span></label>
                                <input type="password" id="pwd" name="pwd">
                                <span class="error">${requestScope.errors.pwd}</span>
                            </div>
                            <div>
                                <label for="confirm">Confirmation<span class="required">*</span></label>
                                <input type="password" id="confirm" name="confirm">
                                <span class="error">${requestScope.errors["confirm"]}</span>
                            </div>
                            <div>
                                <label for="email">Votre pseudo</label>
                                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${requestScope.user.pseudo}"/>">
                                <span class="error">${requestScope.errors.pseudo}</span>
                            </div>
                            <div>
                                <input type="submit" value="Envoyer">
                            </div>
                        </fieldset>
                    </form>
                </main>
            </c:otherwise>
        </c:choose>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
