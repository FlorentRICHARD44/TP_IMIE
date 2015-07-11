<%@tag description="ComboBox Tag - Display a ComboBox with List elements (preceded by a 'Aucun' unselectable element). Values can't be retrieved by its id" pageEncoding="UTF-8"%>
<%@attribute name="cbname" required="true" description="name of the ComboBox as used in forms"%>
<%@attribute name="cbselected" required="true" description="String equals to the string of the selected elements"%>
<%@attribute name="cbitems" required="true" type="java.util.List" description="Items listed in the ComboBox."%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="${cbname }">
    <c:set var="selected" scope="page" value=""/>
    <c:if test="${empty cbselected}">
        <c:set var="selected" scope="page" value=" selected"/>
    </c:if>
    <option disabled <c:out value="${selected}"/>>Aucun</option>
    <c:forEach var="element" items="${cbitems}" varStatus="loop">
          <c:set var="selected" scope="page" value=""/>
          <c:if test="${element eq cbselected}">
              <c:set var="selected" scope="page" value=" selected"/>
          </c:if>
          <option <c:out value="${selected}"/> value="${element.id}"><c:out value="${element}"></c:out></option>
    </c:forEach>
</select>
<jsp:doBody/>
