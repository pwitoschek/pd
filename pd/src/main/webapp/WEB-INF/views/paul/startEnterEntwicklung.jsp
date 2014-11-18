<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	$(document).ready(function() {
		if ($("#wickeln").prop('checked')){
			$(".wickelnDetails").show();
		} else {
			$(".wickelnDetails").hide();
		}
		if ($("#stillen").prop('checked')){
			$(".stillenDetails").show();
		} else {
			$(".stillenDetails").hide();
		}
		$("#datetimepicker").datetimepicker({
			dateFormat : "yy-mm-dd",
			timeFormat : "hh:mm:ss"
		});
		$("#wickeln").click(function() { 
			$(".wickelnDetails").toggle();
		});
		$("#stillen").click(function(){
			$(".stillenDetails").toggle();
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
	<form:form modelAttribute="entwicklung">
		<tags:navigation/>
		<div>
			<table>
				<tr>
					<td colspan="2">
						<h2>Allgemeine Angaben zur Kontrolle der aktuellen Entwicklung :)</h2>
					</td>
				</tr>
				<tr>
					<td>Aktueller Zeitstempel:</td>
					<td>
						<form:input path="currentDateAndTime" id="datetimepicker"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="currentDateAndTime"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Gewicht:</td>
					<td><form:input path="gewicht" /> Gramm</td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="gewicht" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Baby gestillt?</td>
					<td>
						<form:checkbox path="stillen" value="true" id="stillen"/>
					</td>
				</tr>
				<tr class="stillenDetails">
					<td>Bemerkung zum Stillen (optional):</td>
					<td>
						<form:textarea path="stillenBemerkung" rows="3" cols="40" />
					</td>
				</tr>
				<tr>
					<td>Gewickelt?</td>
					<td>
						<form:checkbox path="wickeln" value="true" id="wickeln"/>
					</td>
				</tr>
				<tr class="wickelnDetails">
					<td>Pipi in der Windel?</td>
					<td>
						<form:checkbox path="pipi" value="true"/>
					</td>
				</tr>
				<tr class="wickelnDetails">
					<td>Kacka in der Windel?</td>
					<td>
						<form:checkbox path="kaka" value="true"/>
					</td>
				</tr>
				<tr>
					<td>Bemerkung (optional):</td>
					<td>
						<form:textarea path="bemerkung" rows="3" cols="40" />
					</td>
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