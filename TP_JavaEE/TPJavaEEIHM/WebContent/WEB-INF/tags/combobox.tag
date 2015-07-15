<%@tag description="ComboBox Tag - Display a ComboBox with List elements (preceded by a 'Aucun' unselectable element). Values can't be retrieved by its id" pageEncoding="UTF-8"%>
<%@attribute name="cbname" required="true" description="name of the ComboBox as used in forms"%>
<%@attribute name="cbselected" required="true" description="String equals to the string of the selected elements"%>
<%@attribute name="cbitems" required="true" type="java.util.List" description="Items listed in the ComboBox."%>
<%@attribute name="noneselecteable" required="false" type="java.lang.Boolean" description="Indicates if the None item can be selectable or not" %>
<%@attribute name="itemall" required="false" type="java.lang.Boolean" description="Indicates if the All item shall be set in the list" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>

<select name="${cbname }">
    <c:set var="selected" scope="page" value=""/>
    <c:if test="${empty cbselected}">
        <c:set var="selected" scope="page" value=" selected"/>
    </c:if>
    <c:set var="disabled" scope="page" value="disable"/>
    <c:if test="${noneselectable}==true">
        <c:set var="disabled" scope="page" value=" "/>
    </c:if>
    <c:if test="${itemall }">
    	<option <c:out value="${selected}"/>><fmt:message key="text.all" bundle="${propertie }"/></option>
    </c:if>
    <c:set var="selected" scope="page" value=""/>
    <c:if test="${cbselected == '-'}">
        <c:set var="selected" scope="page" value=" selected"/>
    </c:if>
    
    <option <c:out value="${disabled}"/> <c:out value="${selected}"/>>-</option>
    <c:forEach var="element" items="${cbitems}" varStatus="loop">
          <c:set var="selected" scope="page" value=""/>
          <c:if test="${element eq cbselected}">
              <c:set var="selected" scope="page" value=" selected"/>
          </c:if>
          <option <c:out value="${selected}"/> value="${element.id}"><c:out value="${element}"></c:out></option>
    </c:forEach>
</select>
<jsp:doBody/>
