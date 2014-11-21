<%@page import="de.app.pd.entities.pv.Tagesertrag"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="resources/javascript/jquery-1.9.1.js"></script>
<title>Übersicht Verbrauch</title>
</head>
<body>
<h1>Schritt 3: Bitte Angaben kontrollieren</h1>

	<form:form id="pageForm">
	<tags:navigation/>
		<div>
			<table>
				<tr>
					<td>Aktueller Zeitstempel:</td>
					<td>
						<c:out value="${tagesverbrauch.currentDateAndTime }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Aktueller Wochentag:</td>
					<td>
						<c:out value="${tagesverbrauch.weekDay }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Durchschnittstemperatur:</td>
					<td>
						<c:out value="${tagesverbrauch.durchschnittsTemperatur }"></c:out>
					</td>
				</tr>
					<tr>
						<td>Tagesverbrauch:</td>
						<td>
							<c:out value="${tagesverbrauch.gebrauchteKWH }"></c:out>
						</td>
					</tr>
			</table>
		</div>
		<div>
			<input type="submit" name="_eventId_submit" value="weiter"/>
			<input type="submit" name="_eventId_back" value="zurueck" />
		</div>
	</form:form>
</body>
</html>