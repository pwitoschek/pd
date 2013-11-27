<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>&Uuml;bersicht des Tagesverbrauches</title>
</head>
	<table>
		<thead>
			<tr>
				<th>Datum</th>
				<th>Wochentag</th>
				<th>Temperatur</th>
				<th>KW/H Gesamt</th>
				<th>KW/H Tag</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tagesverbrauchs}" var="tagesverbrauch">
				<tr>
					<td>${tagesverbrauch.currentDateAndTime}</td>
					<td>${tagesverbrauch.weekDay}</td>
					<td>${tagesverbrauch.durchschnittsTemperatur}</td>
					<td>${tagesverbrauch.gebrauchteKWH}</td>
					<td>${tagesverbrauch.sumToday}</td>
				<tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" style="text-align:right;">Anzahl Eintr&auml;ge ${tagesverbrauchs.size() }</td>
			</tr>
		</tfoot>
	</table>
<body>

</body>
</html>