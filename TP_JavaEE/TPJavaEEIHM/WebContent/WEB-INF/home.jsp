<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<c:set var="title" scope="page"><fmt:message key="menu.home" bundle="${propertie }"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">
    <div class="path">  <!-- Chemin de la page actuelle dans le site -->
        <a href="home"><fmt:message key="menu.home" bundle="${propertie }"/></a>
    </div>
    <section class="nolocalmenu">
        <h2><fmt:message key="text.welcome" bundle="${propertie }"/></h2>
    </section>
</t:maintemplate>
