<%@ tag import="de.app.navigation.NavigationItem"%>
<%@ tag import="de.app.navigation.Navigation"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function addHiddenElement(target) {
		if ($('#' + target).length === 0) {
			$("<input name='target' value='"+target+"' type='hidden' />")
					.appendTo($('form'));
		}
	}
</script>

<c:forEach var="item" items="${navigation.itemList}">
<c:choose>
		<c:when test="${item.reachable}">
			<c:choose>
				<c:when test="${item.active}">
					<div class="tab active ">
						<input type="submit" name="_eventId_navi" value="${item.name}"
							onclick="addHiddenElement('${item.name}')"
							style="color: blue; font-weight: bold;" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="tab selectable ">
						<input type="submit" name="_eventId_navi" value="${item.name}"
							onclick="addHiddenElement('${item.name}')" style="color: blue;" />
					</div>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<div class="tab inactive ">
				<input type="submit" name="_eventId_navi" disabled
					value="${item.name}" onclick="addHiddenElement('${item.name}')"
					style="color: red;" />
			</div>
		</c:otherwise>
	</c:choose>
</c:forEach>
