<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >

<fieldset>
	<div class="table">
		<div class="table-row">
			<div class="table-cell"><label>Nom</label></div>
			<c:set var="sitename"></c:set>
			<c:if test="${! empty site }">
				<c:set var="sitename"><c:out value="${site.nom }"/></c:set>
			</c:if>
			<div class="table-cell"><input id="sitename" type="text" required placeholder="Entrer le nom du site" value="<c:out value="${sitename}"/>"/></div>
		</div>
	</div>
</fieldset>
<p class="error" hidden="true"></p>
<c:if test="${! empty site }">
	<button id="del" class="button action">Supprimer</button>
</c:if>
<button id="save" class="button action">Enregistrer</button>
