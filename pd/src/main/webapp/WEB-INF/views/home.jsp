<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="resources/javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasTextRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasAxisLabelRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.canvasAxisTickRenderer.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jquery.jqplot.js"></script>
<script type="text/javascript" src="resources/javascript/plot/jqplot.dateAxisRenderer.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/plot/jquery.jqplot.css" />
<script type="text/javascript">
$(document).ready(function(){
	
	init();
	
	$("#refresh").click(function(){getResult($("#date1").val(), $("#date2").val());});
	
	
});

function getResult(date1, date2){
	var url = "/pd/entwicklung.json";
	$.ajax({
		type : "GET",
		url : url,
		cache : false,
		data : { fromDate1: date1 , toDate2: date2},
		dataType : "json",
		success : function(response){
			console.info("success");
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
			console.info("error");
		}
		
	});
}

function init(){
	var line2 = [['18.11.2014 05:00', 2590], ['17.11.2014 06:00', 2570], ['16.11.2014 07:00', 2560], ['15.11.2014 08:00', 2540]];
	 
    var plot2 = $.jqplot('chart1', [line2], {
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
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<input type="text" id="date1"/>
	<input type="text" id="date2"/>
	<button id="refresh" type="button"/>Refresh</button>
	
	<div id="chart1"></div>
</body>
</html>
