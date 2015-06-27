<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:maintemplate pagetitle="Liste des Usagers" tabtitle="Liste des Utilisateurs">
    <div class="path">  <!-- Chemin de la page actuelle dans le site -->
        <a href="home">Accueil</a> > <a href="userlist"> Liste Usagers</a>
    </div>
    <aside id="menulocal">  <!-- Menu local -->
        <h2>Base Usagers</h2>
        <ul>
            <li><a href="userlist">Liste des Usagers</a></li>
            <li><form method="post" action="userview"><input class="localmenu" type="submit" name="new" value="Ajouter un Usager"/></form></li>
        </ul>
    </aside>
    
    <section>
    	<form method="post" action="userview">
    		<div id="delall"><input type="submit" class="action" name="delselected" value="Supprimer tous les usagers sélectionnés"/></div>
	        <table class="listing">
	            <tr><th></th><th>Nom</th><th>Prénom</th><th></th></tr>
	            <c:forEach var="user" items="${userlist}" varStatus="loop">
	                <tr><td><input type="checkbox" name="selected" value="${loop.count}"/></td>
	                	<td><c:out value="${user.name}"/></td><td><c:out value="${user.firstName}"/></td>
	                    <td><input type="submit" class="btn view" name="view" value="${loop.count}"/><input type="submit" class="btn del" name="delete"value="${loop.count}"/>
	                    </td></tr>
	            </c:forEach>
	        </table>
        </form>
    </section>
</t:maintemplate>
        