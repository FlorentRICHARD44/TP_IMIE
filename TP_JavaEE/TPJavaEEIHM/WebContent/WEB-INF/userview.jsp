<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:choose>
    <c:when test="${empty usager }"><c:set var="pagetitle" scope="page" value="Nouvel Usager"/></c:when>
    <c:otherwise><c:set var="pagetitle" scope="page" value="Usager ${usager.prenom } ${usager.nom }" /></c:otherwise>
</c:choose>
<t:maintemplate pagetitle="${pagetitle}" tabtitle="Usager">
	<form method="post" action="userview">
		<fieldset>
			<input type="text" hidden="true" name="id" value="${usager.id }"/>
			<div><label>Nom: </label><input required type="text" name="name" value="${usager.nom }"/></div>
			<div><label>Prénom: </label><input required type="text" name="firstname" value="${usager.prenom }"/></div>
			<div><label>E-mail: </label><input type="text" name="email" value="${usager.email }"/></div>
			<div><label>Nombre de connexions: </label><input type="number" name="nbconnexion" value="${usager.nbConnexion }"/></div>
			<div><label>Date de naissance: </label><input type="text" name="dateofbirth" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usager.datenaissance}" />"/></div>
			<div><label>Site: </label><t:combobox cbselected="${usager.site }" cbitems="${sitelist}" cbname="site"></t:combobox></div>
			<input type="password" hidden name="password" value="${usager.password }"/>
			<div><input type="submit" class="action" value="Enregistrer" name="save"/>
				<c:if test="${! empty usager.id }">
					<input type="submit" class="action" value="Supprimer" name="del"/>
				</c:if>
			</div>
		</fieldset>
	</form>
</t:maintemplate>
