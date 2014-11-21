<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<html>
<head>
<title>Gewichtsverlauf</title>
<script type="text/javascript" src="resources/javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasTextRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasAxisLabelRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasAxisTickRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jquery.jqplot.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.dateAxisRenderer.js"></script>
<script type="text/javascript"src="resources/javascript/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/plot/jquery.jqplot.css" />
<link type="text/css" rel="stylesheet" href="resources/css/ui-lightness/jquery-ui-1.10.3.custom.css">
<link type="text/css" rel="stylesheet" href="resources/css/jquery-ui-timepicker-addon.css">

<script type="text/javascript">
$(document).ready(function(){
	
	getResult($("input[name='date1']").val(), $("input[name='date2']").val());
	
	$("#refresh").click(function(){getResult($("input[name='date1']").val(), $("input[name='date2']").val());});
	
	
});

function getResult(date1, date2){
	console.info(date2);
	var url = "/pd/entwicklung.json";
	$.ajax({
		type : "GET",
		url : url,
		cache : false,
		data : { fromDate1: date1 , toDate2: date2},
		dataType : "json",
		success : function(msg, testStatus){
			var result = [];
			console.info(msg);
			for (var i = 0; i < msg.length; i++){
				var temp = [msg[i].datum, msg[i].gewicht];
				result.push(temp);
				
			}
			console.info(result);
			$("#chart1").html("");
			init(result);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
		}
		
	});
}

function init(line){
	//var line2 = [['18.11.2014 05:00', 2590], ['17.11.2014 06:00', 2570], ['16.11.2014 07:00', 2560], ['15.11.2014 08:00', 2540]];
	 console.info(line);
    var plot2 = $.jqplot('chart1', [line], {
	  series:[{showMarker:true}],
      axes: {
        xaxis: {
          renderer: $.jqplot.DateAxisRenderer,
          label: 'Zeitlicher Verlauf',
          labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
          tickRenderer: $.jqplot.CanvasAxisTickRenderer,
          tickOptions: {
              // labelPosition: 'middle',
              angle: 15
          }
           
        },
        yaxis: {
          label: 'Gewicht in Gramm',
          labelRenderer: $.jqplot.CanvasAxisLabelRenderer
        }
      }
    });
}
</script>

</head>
<body>
	<h1>Gewichtsverlauf</h1>

	<P>The time on the server is ${serverTime}.</P>
	
	<input type="text" name="date1" value="2014-11-03" id="datetimepicker"/>
	<input type="text" name="date2" value="${now}" id="datetimepicker"/>
	<button id="refresh" type="button">Refresh</button>
	
	<div id="chart1"></div>
</body>
</html>
