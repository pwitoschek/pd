<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${tagesertrag.weekDay }"></c:out>

	<form:form modelAttribute="tagesertrag">
		<div>
			<table>
				<tr>
					<td>Bitte geben Sie den heutigen Ertrag ein:</td>
					<td><form:input path="ertrag"/></td>
				</tr>
				<tr>
					<td>Bitte geben Sie die heutige Durchschnittstemperatur ein:</td>
					<td><form:input path="durchschnittsTemperatur"/></td>
				</tr>
			</table>
		</div>
		<div>
			<input type="submit" name="_eventId_save" value="weiter"/>
			<input type="submit" name="_eventId_cancel" value="abbrechen" />
		</div>
	</form:form>
</body>
</html>