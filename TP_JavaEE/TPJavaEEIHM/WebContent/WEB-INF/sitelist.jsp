<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<c:set var="title" scope="page"><fmt:message key="menu.siteslist" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">
	<form method="post" action="siteview">
		<input type="submit" class="action" name="new" value="<fmt:message key="action.addsite" bundle="${propertie}"/>"/>
	</form>
	<table>
		<tr><th><fmt:message key="site.name" bundle="${propertie}"/></th><th></th></tr>
		<form method="post" action="sitelist">
			<tr><td><input type="text" name="name" value="${param.name }"/></td>
					<td><input type="submit" class="action" value="<fmt:message key="action.filter" bundle="${propertie}"/>" name="filter"/></td></tr>
		</form>
        <form method="post" action="siteview">
         <c:forEach var="site" items="${sitelist}" varStatus="loop">
             <tr><td><c:out value="${site.nom}"/></td>
                 <td><input type="submit" class="btn view" name="view" value="${site.id}"/>
                  <input type="submit" class="btn del" name="del" value="${site.id}"/>
                 </td></tr>
         </c:forEach>
         <c:if test="${empty sitelist }">
         	<tr><td colspan="3"><p class="error"><fmt:message key="site.error.nositefiltered" bundle="${propertie}"/></p></td></tr>
         </c:if>
        </form>
	</table>
</t:maintemplate>
