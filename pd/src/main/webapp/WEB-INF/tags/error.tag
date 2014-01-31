<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="property" description="Gibt Validierungsergebnisse zu einem Property aus" required="true"%>

<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
	<c:if test="${message.source} eq ${property}">
		<c:out value="${message.text}"></c:out>
	</c:if>
</c:forEach>