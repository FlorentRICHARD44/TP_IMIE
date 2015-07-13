<%@tag description="Main Tempalte Tag" pageEncoding="UTF-8"%>
<%@attribute name="tabtitle" required="true"%>
<%@attribute name="pagetitle" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
		<fmt:setLocale value="${requestheaderbean.lang }"/>
		<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title><c:out value="${tabtitle}"/></title>
    </head>
    <body>
        <c:set var="title" scope="request" value="${pagetitle }" />   
        <jsp:include page="/WEB-INF/menu.jsp" />
        <div class="main">
            <jsp:doBody/>
        </div>
       <jsp:include page="/WEB-INF/footer.jspf" />
    </body>
</html>
