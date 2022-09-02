<%-- 
    Document   : profile
    Created on : 6 mai 2022, 08:39:28
    Author     : Nichita Veaceslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/styletheo.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/footer.css'/>">
    </head>
    <body>
        <c:forEach var="message" items="${requestScope.profileMessage}">
            <div class="${message.key}"><c:out value="${message.value}"/></div>
        </c:forEach>

        <%@include file="./jspf/header.jspf" %>
        <br><br><br>
        <%-- afficher les informations liées à l'utilisateur : 
                id, adresse mail et pseudo --%>
        <!-- print Box -->
        <div>
            <h2>Vos Données</h2>
            <p>Identifiant : <c:out value="${sessionScope.user.id}"/></p>
            <p>Adresse courriel : <c:out value="${sessionScope.user.email}"/></p>
            <p>Pseudo : <c:out value="${sessionScope.user.pseudo}"/></p>
        </div>

        <!-- change pwd Box -->
        <form action="" method="post">
            <fieldset>
                <h2>Changer de mot de passe</h2>
                <div>
                    <label for="name">Ancien mot de passe<span class="required">*</span></label>
                    <input type="password" id="pwd" name="pwd">
                    <span class="error">${requestScope.errors.pwd}</span>
                </div>
                <div>
                    <label for="pwd">Nouveau mot de passe<span class="required">*</span></label>
                    <input type="password" id="newPWD" name="newPWD">
                    <span class="error">${requestScope.errors.newPWD}</span>
                </div>
                <div>
                    <label for="confirm">Confirmation<span class="required">*</span></label>
                    <input type="password" id="confirm" name="confirm">
                    <span class="error">${requestScope.errors["confirm"]}</span>
                </div>

                <div>
                    <input type="submit" value="Envoyer">
                </div>
            </fieldset>
        </form>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
