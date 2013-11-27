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
	<h1>Tagesverbrauch</h1>
	Aktuelle ViewId: <c:out value="${flowExecutionContext.activeSession.state.id}"/>
	<form:form modelAttribute="tagesverbrauch">
		<div>
			<table>
				<!-- 
				<tr>
					<td colspan="2">
						<h2>Allgemeine Angaben zum Tagesverbrauch</h2>
					</td>
				</tr>
				<tr>
					<td>Aktueller Zeitstempel</td>
					<td>
						<form:input path="currentDateAndTime"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<form:errors path="currentDateAndTime" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td>Wochentag</td>
					<td><form:input path="weekDay"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<form:errors path="weekDay" cssClass="error"/>
					</td>
				</tr>
				 -->
				<tr>
					<td colspan="2">
						<h2>Spezifischen Angaben zum Verbrauch</h2>
					</td>
				</tr>
				<tr>
					<td>Bitte geben Sie den heutigen Verbrauch ein:</td>
					<td><form:input path="gebrauchteKWH"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<form:errors path="gebrauchteKWH" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td>Bitte geben Sie die heutige Durchschnittstemperatur ein:</td>
					<td><form:input path="durchschnittsTemperatur"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<form:errors path="durchschnittsTemperatur" cssClass="error"/>
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