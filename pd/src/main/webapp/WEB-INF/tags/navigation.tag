<%@ tag import="de.app.navigation.NavigationItem"%>
<%@ tag import="de.app.navigation.Navigation" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Navigation nav = (Navigation)request.getSession().getAttribute("navigation");
	
	if (nav != null){
		for (int i = 0; i < nav.getItemList().size(); i++){
			NavigationItem item = nav.getItemList().get(i);
			System.out.println(item.getName());
		}
	} else {
		System.out.println("nav == null");
	}
	String test = "213";
	System.out.println(test);
%>
<c:forEach var="item" items="${navigation.itemList}">
	<a href="<c:out value='${item.uri}'/>" ><c:out value='${item.name}'/></a>
</c:forEach>
