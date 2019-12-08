<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h2>DOANH SỐ TỪNG THÁNG</h2>
	<p>The .table class adds basic styling (light padding and only
		horizontal dividers) to a table:</p>
	<table class="table">
		<thead>
			<tr>
				<th>Tháng</th>
				<th>Số lượng bán</th>
				<th>Doanh số</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" items="${data}">
				<tr>
					<td>${array[0]}</td>
					<td>${array[1]}</td>
					<td><fmt:formatNumber value="${array[2]}" /> VNĐ</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    var mydata = [ 
		[ 'Tháng', 'Doanh số' ],
		<c:forEach var="array" items="${data}">
		[ '${array[0]}', ${array[2]} ], 
		</c:forEach>
		];
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable(mydata);

        var options = {
          title: '',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
<div id="curve_chart" style="width: 900px; height: 500px"></div>