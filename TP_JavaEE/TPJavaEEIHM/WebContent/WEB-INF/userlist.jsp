<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<c:set var="title" scope="page"><fmt:message key="menu.usagerslist" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">

    <div class="path">  <!-- Chemin de la page actuelle dans le site -->
        <a href="home"><fmt:message key="menu.home" bundle="${propertie}"/></a> > <a href="userlist"><fmt:message key="menu.usagerslist" bundle="${propertie}"/></a>
    </div>
    <aside id="menulocal">  <!-- Menu local -->
        <h2><fmt:message key="usager.baseusagers" bundle="${propertie}"/></h2>
        <ul>
            <li><a href="userlist"><fmt:message key="menu.usagerslist" bundle="${propertie}"/></a></li>
            <li><form method="post" action="userview"><input class="localmenu" type="submit" name="new" value="<fmt:message key="usager.new" bundle="${propertie}"/>"/></form></li>
        </ul>
    </aside>
    
    <section>
		<table class="listing">
			<tr><th><fmt:message key="usager.lastname" bundle="${propertie}"/></th><th><fmt:message key="usager.firstname" bundle="${propertie}"/></th><th><fmt:message key="site" bundle="${propertie}"/></th><th></th></tr>
			<form method="post" action="userlist">
				<tr><td><input type="text" name="name" value="${param.name }"/></td>
						<td><input type="text" name="firstname" value="${param.firstname }"/></td>
						<td></td>
						<td><input type="submit" class="action" value="<fmt:message key="action.filterbyname" bundle="${propertie}"/>" name="filterFullName"/></td></tr>
				<tr><td></td><td></td>
				    <td><t:combobox cbselected="${site }" cbitems="${sitelist}" cbname="site" noneselecteable="true" none="true" itemall="true"></t:combobox></td>
				    <td><input type="submit" class="action" value="<fmt:message key="action.filterbysite" bundle="${propertie}"/>" name="filterSite"/></tr>
			</form>
	           <form method="post" action="userview">
	            <c:forEach var="user" items="${usagerlist}" varStatus="loop">
	                <tr><td><c:out value="${user.nom}"/></td>
	                	<td><c:out value="${user.prenom}"/></td>
	                    <td><c:out value="${user.site}"/></td>
	                    <td><input type="submit" class="btn view" name="view" value="${user.id}"/>
		                    <input type="submit" class="btn del" name="del" value="${user.id}"/>
	                    </td></tr>
	            </c:forEach>
	            <c:if test="${empty usagerlist }">
	            	<tr><td colspan="3"><p class="error"><fmt:message key="usager.error.nousagerfiltered" bundle="${propertie}"/></p></td></tr>
	            </c:if>
	           </form>
		</table>
	</section>
</t:maintemplate>
