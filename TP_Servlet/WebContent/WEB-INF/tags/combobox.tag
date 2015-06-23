<%@tag description="ComboBox Tag" pageEncoding="UTF-8"%>
<%@attribute name="cbname" required="true"%>
<%@attribute name="cbselected" required="true"%>
<%@attribute name="cbitems" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select id="site" name="${cbname }">
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
          <option <c:out value="${selected}"/> value="${loop.count}"><c:out value="${element}"></c:out></option>
    </c:forEach>
</select>
<jsp:doBody/>
