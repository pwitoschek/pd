<%@page import="de.app.pd.entities.pv.Tagesertrag"%>
<%@page import="java.util.Enumeration"%>
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

	<form:form modelAttribute="tagesertrag">
		<div>
			Bitte kontrollieren Sie Ihre Angaben:
			<table>
				<tr>
					<td>Aktueller Zeitstempel:</td>
					<td>
						<c:out value="${tagesertrag.currentDateAndTime }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Aktueller Wochentag:</td>
					<td>
						<c:out value="${tagesertrag.weekDay }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Durchschnittstemperatur:</td>
					<td>
						<c:out value="${tagesertrag.durchschnittsTemperatur }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Tagesertrag:</td>
					<td>
						<c:out value="${tagesertrag.ertrag }"></c:out>
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