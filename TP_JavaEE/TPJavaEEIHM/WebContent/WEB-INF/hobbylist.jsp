<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<c:set var="title" scope="page"><fmt:message key="menu.hobbieslist" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">
	<form method="post" action="hobbyview">
		<input type="submit" class="action" name="newsport" value="<fmt:message key="action.addhobby.sport" bundle="${propertie}"/>"/>
		<input type="submit" class="action" name="newmusic" value="<fmt:message key="action.addhobby.music" bundle="${propertie}"/>"/>
	</form>
	<table>
		<tr><th><fmt:message key="hobby.name" bundle="${propertie}"/></th><th></th></tr>
		<form method="post" action="hobbylist">
			<tr><td><input type="text" name="name" value="${param.name }"/></td>
					<td><input type="submit" class="action" value="<fmt:message key="action.filter" bundle="${propertie}"/>" name="filter"/></td></tr>
		</form>
        <form method="post" action="hobbyview">
         <c:forEach var="hobby" items="${hobbylist}" varStatus="loop">
             <tr><td><c:out value="${hobby.nom}"/></td>
                 <td><input type="submit" class="btn view" name="view" value="${hobby.id}"/>
                  <input type="submit" class="btn del" name="del" value="${hobby.id}"/>
                 </td></tr>
         </c:forEach>
         <c:if test="${empty hobbylist }">
         	<tr><td colspan="3"><p class="error"><fmt:message key="hobby.error.nohobbyfiltered" bundle="${propertie}"/></p></td></tr>
         </c:if>
		<c:if test="${error == 'hobbyassignedtousager'}">
			<div><p class="error"><fmt:message key="hobby.error.hobbyassignedtousager" bundle="${propertie}"/></p></div>
		</c:if>
        </form>
	</table>
</t:maintemplate>
