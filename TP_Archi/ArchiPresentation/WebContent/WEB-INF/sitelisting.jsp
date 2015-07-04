<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:maintemplate pagetitle="Liste des Sites" tabtitle="Liste des Sites">
    <div class="path">  <!-- Chemin de la page actuelle dans le site -->
        <a href="home">Accueil</a> > <a href="sitelist"> Liste Sites</a>
    </div>
    <aside id="menulocal">  <!-- Menu local -->
        <h2>Admin Site</h2>
        <ul>
            <li><a href="sitelist">Liste des Sites</a></li>
            <li><form method="post" action="siteview"><input class="localmenu" type="submit" name="new" value="Ajouter un Site"/></form></li>
        </ul>
    </aside>
    
    <section>
    	<form method="post" action="siteview">
    		<div id="delall"><input type="submit" class="action" name="delselected" value="Supprimer tous les sites sélectionnés"/></div>
	        <table class="listing">
	            <tr><th></th><th>Nom</th><th></th></tr>
	            <c:forEach var="site" items="${sitebean.sitelist}" varStatus="loop">
	                <tr><td><input type="checkbox" name="selected" value="${loop.count}"/></td>
	                	<td><c:out value="${site.name}"/></td>
	                    <td><input type="submit" class="btn view" name="view" value="${loop.count}"/><input type="submit" class="btn del" name="delete"value="${loop.count}"/>
	                    </td></tr>
	            </c:forEach>
	        </table>
        </form>
    </section>
</t:maintemplate>
        