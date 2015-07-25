<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
    
<c:choose>
    <c:when test="${empty site }"><c:set var="pagetitle" scope="page"><fmt:message key="site.new" bundle="${propertie}"/></c:set></c:when>
    <c:otherwise><c:set var="pagetitle" scope="page"><fmt:message key="site" bundle="${propertie}"/> ${site.nom }</c:set></c:otherwise>
</c:choose>
<c:set var="tabtitle" scope="page"><fmt:message key="site" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${pagetitle}" tabtitle="${tabtitle }">
	<form method="post" action="siteview">
		<fieldset>
			<input type="text" hidden="true" name="id" value="${site.id }"/>
			<div><label><fmt:message key="site.name" bundle="${propertie}"/></label><input required type="text" name="name" value="${site.nom }"/></div>
			<div><input type="submit" class="action" value="<fmt:message key="action.save" bundle="${propertie}"/>" name="save"/>
				<c:if test="${! empty site.id }">
					<input type="submit" class="action" value="<fmt:message key="action.delete" bundle="${propertie}"/>" name="del"/>
				</c:if>
			</div>
			<div><input type="submit" class="action" value="<fmt:message key="site.viewusagers" bundle="${propertie}"/>" name="viewusagers"/> </div>
		</fieldset>
	</form>
</t:maintemplate>
