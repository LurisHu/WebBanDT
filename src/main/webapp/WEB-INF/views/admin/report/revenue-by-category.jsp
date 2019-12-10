<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>DOANH SỐ THEO DANH MỤC</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Loại</th>
				<th class="text-center">Số lượng bán</th>
				<th class="text-right">Doanh số</th>
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
	<div class="col-12" id="piechart_3d"></div>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var mydata = [ 
			[ 'Danh mục', 'Doanh số' ],
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
