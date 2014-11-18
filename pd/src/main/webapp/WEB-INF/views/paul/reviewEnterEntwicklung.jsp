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
<title>Kontrolle der allgemeinen Angaben</title>
</head>
<body>
<h1>Schritt 2: Bitte Angaben kontrollieren</h1>

	<form:form>
	<tags:navigation/>
		<div>
			<table>
				<tr>
					<td>Aktueller Zeitstempel:</td>
					<td>
						<c:out value="${entwicklung.currentDateAndTime }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Aktueller Wochentag:</td>
					<td>
						<c:out value="${entwicklung.weekDay }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Gewicht:</td>
					<td>
						<c:out value="${entwicklung.gewicht }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Stillen:</td>
					<td>
						<c:out value="${entwicklung.stillen }"></c:out>
					</td>
				</tr>
				<tr>
					<td>Stillen Bemerkung:</td>
					<td>
						<c:out value="${entwicklung.stillenBemerkung}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Wickeln:</td>
					<td>
						<c:out value="${entwicklung.wickeln}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Pipi:</td>
					<td>
						<c:out value="${entwicklung.pipi}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Kaka:</td>
					<td>
						<c:out value="${entwicklung.kaka}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Bemerkung:</td>
					<td>
						<c:out value="${entwicklung.bemerkung}"></c:out>
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