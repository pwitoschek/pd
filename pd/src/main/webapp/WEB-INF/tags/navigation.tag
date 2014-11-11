<%@ tag import="de.app.navigation.NavigationItem"%>
<%@ tag import="de.app.navigation.Navigation"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function addHiddenElement(target) {
		console.info(target);
		console.info($('#pageForm'));
			$("<input name='target' value='"+target+"' type='hidden' />")
					.appendTo($('#pageForm'));
	}
</script>

<c:forEach var="item" items="${navigation.itemList}">
<c:choose>
		<c:when test="${item.reachable}">
			<c:choose>
				<c:when test="${item.active}">
						<input type="submit" name="_eventId_navi" value="${item.displayName}"
							onclick="addHiddenElement('${item.name}')"
							style="color: blue; font-weight: bold;" />
				</c:when>
				<c:otherwise>
						<input type="submit" name="_eventId_navi" value="${item.displayName}"
							onclick="addHiddenElement('${item.name}')" style="color: blue;" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
				<input type="submit" name="_eventId_navi" disabled
					value="${item.displayName}" onclick="addHiddenElement('${item.name}')"
					style="color: red;" />
		</c:otherwise>
	</c:choose>
</c:forEach>
