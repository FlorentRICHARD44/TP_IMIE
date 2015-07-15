<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
    
<c:choose>
    <c:when test="${empty hobby }"><c:set var="pagetitle" scope="page"><fmt:message key="hobby.new" bundle="${propertie}"/></c:set></c:when>
    <c:otherwise><c:set var="pagetitle" scope="page"><fmt:message key="hobby" bundle="${propertie}"/> ${hobby.nom }</c:set></c:otherwise>
</c:choose>
<c:set var="tabtitle" scope="page"><fmt:message key="hobby" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${pagetitle}" tabtitle="${tabtitle }">
	<form method="post" action="hobbyview">
		<fieldset>
			<input type="text" hidden="true" name="id" value="${hobby.id }"/>
			<div><label><fmt:message key="hobby.name" bundle="${propertie}"/></label><input required type="text" name="name" value="${hobby.nom }"/></div>
			<div><input type="submit" class="action" value="<fmt:message key="action.save" bundle="${propertie}"/>" name="save"/>
				<c:if test="${! empty hobby.id }">
					<input type="submit" class="action" value="<fmt:message key="action.delete" bundle="${propertie}"/>" name="del"/>
				</c:if>
			</div>
		</fieldset>
	</form>
</t:maintemplate>
