<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>SỐ LƯỢNG BÁN THEO HÃNG</h2>
	<p>The .table class adds basic styling (light padding and only
		horizontal dividers) to a table:</p>
	<table class="table">
		<thead>
			<tr>
				<th>Hãng</th>
				<th>Số lượng bán</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" items="${data}">
				<tr>
					<td>${array[0]}</td>
					<td>${array[1]} Cái</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var mydata = [ 
			[ 'Hãng', 'Số lượng' ],
			<c:forEach var="array" items="${data}">
			[ '${array[0]}', ${array[1]} ], 
			</c:forEach>
			];
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable(mydata);

		var options = {
			title : '',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
				chart.draw(data, options);
	}
</script>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>