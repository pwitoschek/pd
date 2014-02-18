<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag import="org.springframework.webflow.execution.RequestContext"%>
<%@ tag import="org.springframework.webflow.execution.RequestContextHolder"%>
<%@ attribute name="property" description="Gibt Validierungsergebnisse zu einem Property aus" required="true"%>

<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
	<c:if test="${message.source eq property}">
		<span style="color:red;font-weight:bold;"><c:out value="${message.text}"></c:out></span>
	</c:if>
</c:forEach>