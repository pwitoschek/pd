<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Enter PV Data</title>
	<style type="text/css">
		.error{
			color:red;
		}
	</style>
</head>

<body>
	<b>Aufruf setInitValues():</b><br>
	Ermittelte Wochentag: <c:out value="${tagesertrag.weekDay }"></c:out><br>
	Zeitstempel: <c:out value="${tagesertrag.currentDateAndTime }"></c:out>

	<h1>Tagesertrag</h1>
	Aktuelle ViewId: <c:out value="${flowExecutionContext.activeSession.state.id}"/>
	<form:form modelAttribute="tagesertrag">
		<div>
			<table>
				<tr>
					<td>Bitte geben Sie den heutigen Ertrag ein:</td>
					<td><form:input path="ertrag"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<form:errors path="ertrag" cssClass="error"/>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<input type="submit" name="_eventId_submit" value="weiter"/>
			<input type="submit" name="_eventId_cancel" value="abbrechen" />
		</div>
	</form:form>
</body>
</html>