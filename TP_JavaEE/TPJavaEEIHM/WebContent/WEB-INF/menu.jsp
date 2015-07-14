<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<header>
	<img alt="Logo Cyberbase" src="IMG/Logo_Cyberbase.gif">
	<c:set var="now" value="<%=new java.util.Date()%>" />  
	<h1><c:out value="${title }"/></h1>
	<section id="info_connection">
		<div class="line"><p class="data"><fmt:formatDate pattern="dd/MM/yyyy" value="${now}" /></p></div>
		<div class="line"><p class="data"><fmt:message key="menu.info.user" bundle="${propertie}"/> : <c:out value="${connecteduserbean.user.prenom}"/> <c:out value="${connecteduserbean.user.nom}"/></p></div>
		<div class="line"><p class="data"><c:out value="${openconnectionsbean.visitors}"/> <fmt:message key="menu.info.visitors" bundle="${propertie}"/>, <fmt:message key="menu.info.included" bundle="${propertie}"/> <c:out value="${openconnectionsbean.loggedUsers}"/> <fmt:message key="menu.info.logged" bundle="${propertie}"/></p></div>
	</section>
</header>
<nav><div class="menu"><div class="menuitem"><a href="home"><fmt:message key="menu.home" bundle="${propertie}"/></a></div><div class="menuitem"><a href="userlist"><fmt:message key="menu.usagerslist" bundle="${propertie}"/></a></div><div class="menuitem"><a href="sitelist"><fmt:message key="menu.siteslist" bundle="${propertie}"/></a></div></div>
	<form method="post" action="logout" ><input type="submit" value="<fmt:message key="menu.logout" bundle="${propertie}"/>" name="logout" /></form>
</nav>
