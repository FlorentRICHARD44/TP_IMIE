<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:choose>
    <c:when test="${empty sitebean.site }"><c:set var="pagetitle" scope="page" value="Nouveau Site"/></c:when>
    <c:otherwise><c:set var="pagetitle" scope="page" value="Site ${sitebean.site.name }" /></c:otherwise>
</c:choose>
<t:maintemplate pagetitle="${pagetitle}" tabtitle="Site">
    <fmt:setLocale value="${lang }"/>
    <fmt:setBundle basename="fr.imie.formation.servlet.userview" var="propertie"/>
    <div class="path">  <!-- Chemin de la page actuelle dans le site -->
        <a href="home">Accueil</a> > <a href="sitelist">Liste Sites</a> > <a href="siteview">Vue Site</a>
    </div>
    <aside id="menulocal">  <!-- Menu local -->
        <h2>Admin Site</h2>
        <ul>
            <li><a href="sitelist">Liste des Sites</a></li>
            <li><form method="post" action="siteview"><input class="localmenu" type="submit" name="new" value="Ajouter un Site"/></form></li>
        </ul>
    </aside>
    <section>
        <ul id="listelocale">
            <li> </li>
            <li> </li>
        </ul>
        <div class="actionzone">
            <h1>Gestion Site</h1>
            <form method="post" action="siteview"><input id="new" class="action" type="submit" name="new" value="Ajouter un Site"/></form>
            <div class="displayzone">
                <form method="post" action="siteview">
                    <fieldset>
                        <table>
                            <caption>Modification des informations du site</caption>
                            <tr><td><label for="name">Nom</label></td>
                                <td><input id="name" name="name" type="text" required value="${sitebean.site.name}" placeholder="NOM"/></td></tr>
                            <tr><td colspan="2"><p class="error"> </p></td></tr>
                            <tr><td colspan="2"><input class="button action" id="init" type="reset" value="Réinitialiser"/><input class="button action" id="saveuser" type="submit" name="save" value="Enregistrer"/></td></tr>
                        </table>
                    </fieldset>
                </form>
                <form  class="bottom" method="post" action="siteview">
                     <c:if test="${!empty sitebean.site.id }"><!-- Can't delete on usager creation -->
                        <input class="button action" id="delete" type="submit" name="delete" value="Supprimer le site"/>
                    </c:if>
                </form>
            </div>
        </div>
    </section>
</t:maintemplate>
