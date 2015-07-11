<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:maintemplate pagetitle="Liste des Usagers" tabtitle="Liste des Utilisateurs">
		<form method="post" action="userview">
			<input type="submit" class="action" name="new" value="Ajouter un usager"/>
		</form>
		<table>
			<tr><th>Nom</th><th>Prénom</th><th></th></tr>
			<form method="post" action="userlist">
				<tr><td><input type="text" name="name" value="${param.name }"/></td>
						<td><input type="text" name="firstname" value="${param.firstname }"/></td>
						<td><input type="submit" class="action" value="Filtrer" name="filter"/></td></tr>
			</form>
            <form method="post" action="userview">
	            <c:forEach var="user" items="${usagerlist}" varStatus="loop">
	                <tr><td><c:out value="${user.nom}"/></td><td><c:out value="${user.prenom}"/></td>
	                    <td><input type="submit" class="btn view" name="view" value="${user.id}"/>
		                    <input type="submit" class="btn del" name="del" value="${user.id}"/>
	                    </td></tr>
	            </c:forEach>
	            <c:if test="${empty usagerlist }">
	            	<tr><td colspan="3"><p class="error">Aucun usager ne correspond aux critères de filtres</p></td></tr>
	            </c:if>
            </form>
		</table>
</t:maintemplate>
