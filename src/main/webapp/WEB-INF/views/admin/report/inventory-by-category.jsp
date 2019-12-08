<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>TỒN KHO</h2>
	<p>The .table class adds basic styling (light padding and only
		horizontal dividers) to a table:</p>
	<table class="table">
		<thead>
			<tr>
				<th>Loại</th>
				<th>Số lượng tồn</th>
				<th>Giá trị</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" items="${data}">
				<tr>
					<td>${array[0]}</td>
					<td>${array[1]}</td>
					<td><fmt:formatNumber value="${array[2]}"/> VNĐ</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var mydata = [ 
			[ 'Loại', 'Giá trị' ],
			<c:forEach var="array" items="${data}">
			[ '${array[0]}', ${array[2]} ], 
			</c:forEach>
			];
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable(mydata);

		var options = {
			title : 'Inventory By Category',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
				chart.draw(data, options);
	}
</script>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>