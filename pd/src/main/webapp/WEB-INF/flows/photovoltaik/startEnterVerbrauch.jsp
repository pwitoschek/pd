<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Enter PV Data</title>

<link type="text/css" rel="stylesheet"
	href="resources/css/ui-lightness/jquery-ui-1.10.3.custom.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/jquery-ui-timepicker-addon.css">

<script type="text/javascript"
	src="resources/javascript/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="resources/javascript/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<script>
	$(function() {
		$("#datetimepicker").datetimepicker({
			dateFormat : "yy-mm-dd",
			timeFormat : "hh:mm:ss"
		});
	});
</script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body>
	<form:form modelAttribute="tagesverbrauch">
		<tags:navigation/>
		<div>
			<table>
				<tr>
					<td colspan="2">
						<h2>Allgemeine Angaben zum Tagesverbrauch</h2>
					</td>
				</tr>
				<tr>
					<td>Aktueller Zeitstempel</td>
					<td><form:input path="currentDateAndTime" id="datetimepicker" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="currentDateAndTime"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Wochentag</td>
					<td><form:input path="weekDay" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="weekDay" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<h2>Spezifischen Angaben zum Verbrauch</h2>
					</td>
				</tr>
				<tr>
					<td>Bitte geben Sie den heutigen Verbrauch ein:</td>
					<td><form:input path="gebrauchteKWH" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="gebrauchteKWH"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Bitte geben Sie die heutige Durchschnittstemperatur ein:</td>
					<td><form:input path="durchschnittsTemperatur" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="durchschnittsTemperatur"
							cssClass="error" /></td>
				</tr>
			</table>
		</div>
		<div>
			<input type="submit" name="_eventId_submit" value="weiter" /> <input
				type="submit" name="_eventId_back" value="zurueck" />
		</div>
	</form:form>
</body>
</html>