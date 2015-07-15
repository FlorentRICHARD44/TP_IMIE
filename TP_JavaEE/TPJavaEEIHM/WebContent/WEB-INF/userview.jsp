<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
    
<c:choose>
    <c:when test="${empty usager }"><c:set var="pagetitle" scope="page"><fmt:message key="usager.new" bundle="${propertie}"/></c:set></c:when>
    <c:otherwise><c:set var="pagetitle" scope="page"><fmt:message key="usager" bundle="${propertie}"/> ${usager.prenom } ${usager.nom }</c:set></c:otherwise>
</c:choose>
<c:set var="tabtitle" scope="page"><fmt:message key="usager" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${pagetitle}" tabtitle="${tabtitle }">
	<form method="post" action="userview">
		<fieldset>
			<table>
				<tr><td><input type="text" hidden="true" name="id" value="${usager.id }"/></td></tr>
				<tr><td><label><fmt:message key="usager.lastname" bundle="${propertie}"/></label></td>
				    <td><input required type="text" name="name" value="${usager.nom }"/></td></tr>
				<tr><td><label><fmt:message key="usager.firstname" bundle="${propertie}"/></label></td>
				    <td><input required type="text" name="firstname" value="${usager.prenom }"/></td></tr>
				<tr><td><label><fmt:message key="usager.email" bundle="${propertie}"/></label></td>
					<td><input type="text" name="email" value="${usager.email }"/></td></tr>
				<tr><td><label><fmt:message key="usager.nbconnection" bundle="${propertie}"/></label></td>
					<td><input type="number" name="nbconnexion" value="${usager.nbConnexion }"/></td></tr>
				<tr><td><label><fmt:message key="usager.dateofbirth" bundle="${propertie}"/></label></td>
				    <td><input type="text" name="dateofbirth" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usager.datenaissance}" />"/></td></tr>
				<tr><td><label><fmt:message key="usager.site" bundle="${propertie}"/></label></td>
				    <td><t:combobox cbselected="${usager.site }" cbitems="${sitelist}" cbname="site" noneselecteable="false"></t:combobox></td></tr>
				<tr><td><label><fmt:message key="usager.hobbies" bundle="${propertie}"/></label></td>
					<td><table>
					 	 	<c:forEach var="hobby" items="${usager.hobbies}" >
					 	 		<tr><td><c:out value="${hobby.nom}"/>
					 	 	</c:forEach>
					 	 	<tr><td>TODO Add hobby</td></tr>
					 	</table></td></tr>
				<tr><td><input type="password" hidden="true" name="password" value="${usager.password }"/></td></tr>
				<tr><td><input type="submit" class="action" value="<fmt:message key="action.save" bundle="${propertie}"/>" name="save"/>
				<c:if test="${! empty usager.id }">
					<input type="submit" class="action" value="<fmt:message key="action.delete" bundle="${propertie}"/>" name="del"/>
				</c:if></td></tr>
			</table>
		</fieldset>
	</form>
</t:maintemplate>
