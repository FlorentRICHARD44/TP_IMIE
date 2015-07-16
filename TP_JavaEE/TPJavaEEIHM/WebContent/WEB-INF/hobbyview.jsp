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
			<input type="text" hidden="true" name="type" value="${hobby.getClass().name }"/>
			<div><label><fmt:message key="hobby.name" bundle="${propertie}"/></label><input required type="text" name="name" value="${hobby.nom }"/></div>
			<c:choose>
				<c:when test="${hobby.getClass().name == 'fr.imie.entities.HobbyMusicEntity'}">
					<div><label><fmt:message key="hobby.music.genre" bundle="${propertie}"/></label>
						 <input type="text" name="genre" value="${hobby.genremusic }"/></div>
				</c:when>
				<c:when test="${hobby.getClass().name == 'fr.imie.entities.HobbySportEntity'}">
					<div><label><fmt:message key="hobby.sport.teamsport" bundle="${propertie}"/></label>
					<c:set var="checked" value=" "/>
					<c:if test="${hobby.team == true }">
						<c:set var="checked" value="checked "/>
					</c:if>
					<input type="checkbox" name="team" <c:out value="${checked }"/>/></div>
				</c:when>
			</c:choose>
			<div><input type="submit" class="action" value="<fmt:message key="action.save" bundle="${propertie}"/>" name="save"/>
				<c:if test="${! empty hobby.id }">
					<input type="submit" class="action" value="<fmt:message key="action.delete" bundle="${propertie}"/>" name="del"/>
				</c:if>
			</div>
			<c:if test="${error == 'hobbyassignedtousager'}">
				<div><p class="error"><fmt:message key="hobby.error.hobbyassignedtousager" bundle="${propertie}"/></p></div>
			</c:if>
		</fieldset>
	</form>
</t:maintemplate>
