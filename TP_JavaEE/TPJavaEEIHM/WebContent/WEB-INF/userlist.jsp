<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
<c:set var="title" scope="page"><fmt:message key="menu.usagerslist" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">
	<form method="post" action="userview">
		<input type="submit" class="action" name="new" value="<fmt:message key="action.addusager" bundle="${propertie}"/>"/>
	</form>
	<table>
		<tr><th><fmt:message key="usager.lastname" bundle="${propertie}"/></th><th><fmt:message key="usager.firstname" bundle="${propertie}"/></th><th></th></tr>
		<form method="post" action="userlist">
			<tr><td><input type="text" name="name" value="${param.name }"/></td>
					<td><input type="text" name="firstname" value="${param.firstname }"/></td>
					<td><input type="submit" class="action" value="<fmt:message key="action.filterbyname" bundle="${propertie}"/>" name="filterFullName"/></td></tr>
			<tr><td><label><fmt:message key="site" bundle="${propertie}"/></label></td>
			    <td><t:combobox cbselected="${site }" cbitems="${sitelist}" cbname="site" noneselecteable="true" itemall="true"></t:combobox></td>
			    <td><input type="submit" class="action" value="<fmt:message key="action.filterbysite" bundle="${propertie}"/>" name="filterSite"/></tr>
		</form>
           <form method="post" action="userview">
            <c:forEach var="user" items="${usagerlist}" varStatus="loop">
                <tr><td><c:out value="${user.nom}"/></td><td><c:out value="${user.prenom}"/></td>
                    <td><input type="submit" class="btn view" name="view" value="${user.id}"/>
	                    <input type="submit" class="btn del" name="del" value="${user.id}"/>
                    </td></tr>
            </c:forEach>
            <c:if test="${empty usagerlist }">
            	<tr><td colspan="3"><p class="error"><fmt:message key="usager.error.nousagerfiltered" bundle="${propertie}"/></p></td></tr>
            </c:if>
           </form>
	</table>
</t:maintemplate>
