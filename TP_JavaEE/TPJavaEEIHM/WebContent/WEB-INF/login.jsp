<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <link rel="shortcut icon" href="IMG/favicon.ico" type="image/x-icon"/>
		<link rel="icon" href="IMG/favicon.ico" type="image/x-icon"/>	
        <title><fmt:message key="login.title" bundle="${propertie}"/></title>
    </head>
    <body>
    	<header>
            <img alt="Logo Cyberbase" src="IMG/Logo_Cyberbase.gif">
        </header>
        <nav>
            <h1><fmt:message key="login.title" bundle="${propertie}"/></h1>
        </nav>
        <div class="main">
            <form class="login" method="post" action="login">
                <fieldset>
                    <div class="formline"><label for="login"><fmt:message key="login.login" bundle="${propertie}"/></label><input id="login" class="input" type="text" required placeholder="Entrer votre login" name="login"/></div>
                    <div class="formline"><label for="pwd"><fmt:message key="login.password" bundle="${propertie}"/></label><input id="pwd" class="input" type="password" required placeholder="Mot de passe" name="pwd"/></div>
                    <div class="formline centered"><input class="action" type="submit" value="<fmt:message key="login.connection" bundle="${propertie}"/>"/></div>
                	<div class="formline">
                        <c:if test="${param.error != null }">
                            <p class="error" ><fmt:message key="login.error" bundle="${propertie}"/></p>
                        </c:if>
                    </div>
                </fieldset>
            </form>
        </div>
	   <jsp:include page="footer.jspf" />
    </body>
</html>
