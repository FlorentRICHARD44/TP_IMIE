<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<c:forEach var="site" items="${sitelist}" varStatus="loop">
    <li class="ui-selectee" data-index="<c:out value="${site.id}"/>"><c:out value="${site.nom}"/></li>
</c:forEach>
