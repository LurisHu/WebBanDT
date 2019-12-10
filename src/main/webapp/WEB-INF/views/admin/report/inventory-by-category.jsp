<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>TỒN KHO</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Danh mục</th>
				<th class="text-center">Số lượng tồn</th>
				<th class="text-right">Giá trị</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" items="${data}">
				<tr>
					<td>${array[0]}</td>
					<td class="text-center">${array[1]}</td>
					<td class="text-right"><fmt:formatNumber value="${array[2]}"/> VNĐ</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h4>Biểu đồ</h4>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var mydata = [ 
			[ 'Danh mục', 'Giá trị' ],
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
			title : '',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
				chart.draw(data, options);
	}
</script>
<div id="piechart_3d" style="width: 1225px; height: 500px;"></div>