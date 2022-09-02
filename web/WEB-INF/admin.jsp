<%-- 
    Document   : admin
    Created on : 11 mai 2022, 14:16:37
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/login.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/footer.css'/>">
    </head>
    <body>
        <c:forEach var="message" items="${requestScope.eventMessage}">
            <div class="${message.key}"><c:out value="${message.value}"/></div>
        </c:forEach>
        <%@include file="./jspf/header.jspf" %>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <%@include file="./jspf/sessionEmpty.jspf" %>
            </c:when>
            <c:otherwise>
                <link rel="stylesheet" href="<c:url value='/rsc/css/styletheo.css'/>">
                <main>

                    <section>
                        <div class="Choisir">
                            <form action="<c:url value="/admin"/>" method="post">
                                <div>
                                    <h2>Crée un évènements</h2>
                                    <div>
                                        <label for="name">Nom de l'évènement</label>
                                        <input type="text" id="title" name="title" class="input" value="<c:out value="${requestScope.event.title}"/>">
                                        <span class="error">${requestScope.errors.title}</span>
                                    </div>
                                    <div>
                                        <label for="date">Date de l'évènement</label>
                                        <input type="date" id="date" name="date" value="<c:out value="${requestScope.event.date}"/>">   
                                        <span class="error">${requestScope.errors.date}</span>
                                    </div>
                                    <div id="Ajouter-Evenement">
                                        <input type="submit" value="Ajouter Evenement">
                                    </div>
                                    <div>
                                        <h3>Ajouter des participants</h3>
                                    </div>

                                    <div>
                                        <label for="name">Nom<span class="required">*</span></label>
                                        <input type="text" id="name" name="name">
                                    </div>
                                    <div>
                                        <label for="name">Prenom<span class="required">*</span></label>
                                        <input type="text" id="name" name="name">
                                    </div>
                                    <div>
                                        <label for="phone">Telephone<span class="required">*</span></label>
                                        <input type="number" id="phone" name="phone">
                                    </div>
                                    <div>
                                        <label for="number">Nombre d'entrée<span class="required">*</span></label>
                                        <input type="number" id="number" name="number">
                                    </div>
                                    <div>
                                        <label for="number">Nombre de plats<span class="required">*</span></label>
                                        <input type="number" id="number" name="number">
                                    </div>
                                    <div>
                                        <label for="number">Nombre de dessert<span class="required">*</span></label>
                                        <input type="number" id="number" name="number">
                                    </div>
                                    <div>
                                        <label for="number">Nombre de boisson<span class="required">*</span></label>
                                        <input type="number" id="number" name="number">
                                    </div>
                                    <div id="Ajouter-participant">
                                        <input type="submit" value="Ajouter participants">
                                    </div>


                                </div>
                            </form>


                        </div>



                    </section>


                    <section class="Menu-Deroulant1">
                        <div>
                            <h2>Choisir l’évènement à afficher</h2>
                        </div>

                        <div class="dropdown">
                            <button onclick="myFunction()" class="dropbtn">Choisir</button>
                            <div id="myDropdown" class="dropdown-content">

                                <c:forEach var="event" items="${requestScope.events}">
                                    <a href="#"><c:out value="${pageScope.event.title}"  /></a>
                                </c:forEach>
                            </div>
                        </div>

                        <div id="button">
                            <button id="Modifier">Modifier l'évènement</button>
                        </div>
                    </section>

                    <section class="tableaux">
                        <div class="tableaux2">
                            <div>
                                <div class="Evenement-block">
                                    <div class="Evenement">
                                        <p>Evènement : </p>
                                    </div>
                                </div>
                                <div class="Tab">
                                    <div>
                                        <p>Nom</p>
                                    </div>
                                    <div>
                                        <p>Prenom</p>
                                    </div>
                                    <div>
                                        <p>Téléphone</p>
                                    </div>
                                    <div>
                                        <p>Entrée</p>
                                    </div>
                                    <div>
                                        <p>Plats</p>
                                    </div>
                                    <div>
                                        <p>Dessert</p>
                                    </div>
                                    <div>
                                        <p>Boisson</p>
                                    </div>
                                    <div>
                                        <p>Remarque</p>
                                    </div>

                                </div>

                                <div class="Trait-Position">
                                    <div class="Trait">

                                    </div>
                                </div>

                                <div class="Tab">
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>
                                    <div>
                                        <p>Donnée</p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </section>

                    <section>



                    </section>














                </main>
            </c:otherwise>
        </c:choose>
        <%@include file="./jspf/footer.jspf" %>
        <%@include file="./jspf/script.jspf" %>
    </body>
</html>
