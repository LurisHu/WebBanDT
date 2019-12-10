<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="row">
		<h2>SỐ LƯỢNG SẢN PHẨM BÁN RA THEO HÃNG</h2>
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
						<td>${array[1]}Sảnphẩm</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row">
		<h4>Biểu đồ</h4>
		<div class="col-12" id="piechart_3d"></div>
	</div>
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
			width: '100%',
            height: '100%',
            chartArea:
            {
                left: "0%",
                top: "10%",
                height: "90%",
                width: "100%"
            }
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
				chart.draw(data, options);
	}
	$( window ).resize(function()
			{
		  console.log("resize");
		  drawChart();
		});
</script>
