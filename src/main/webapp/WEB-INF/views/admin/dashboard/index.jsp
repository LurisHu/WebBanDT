<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
</div>

<!-- Content Row -->
<div class="row">

	<!-- Earnings (Monthly) Card Example -->
	<div class="col-xl-3 col-md-6 mb-4">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div
							class="text-xs font-weight-bold text-primary text-uppercase mb-1">Earnings
							(Monthly)</div>
						<div class="h5 mb-0 font-weight-bold text-gray-800">
						<fmt:formatNumber value="${revenueMonthNow}"/>
						</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-calendar fa-2x text-gray-300"></i>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Earnings (Monthly) Card Example -->
	<div class="col-xl-3 col-md-6 mb-4">
		<div class="card border-left-success shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div
							class="text-xs font-weight-bold text-success text-uppercase mb-1">Earnings
							(Annual)</div>
						<div class="h5 mb-0 font-weight-bold text-gray-800">
						<fmt:formatNumber value="${revenueYearNow}"/>
						</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Earnings (Monthly) Card Example -->
	<!-- <div class="col-xl-3 col-md-6 mb-4">
		<div class="card border-left-info shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div
							class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks</div>
						<div class="row no-gutters align-items-center">
							<div class="col-auto">
								<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
							</div>
							<div class="col">
								<div class="progress progress-sm mr-2">
									<div class="progress-bar bg-info" role="progressbar"
										style="width: 50%" aria-valuenow="50" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<div class="col-xl-3 col-md-6 mb-4">
		<div class="card border-left-info  shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div
							class="text-xs font-weight-bold text-warning text-uppercase mb-1">Admin</div>
						<div class="h5 mb-0 font-weight-bold text-gray-800">
						${adminNow}
						</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-user fa-2x text-gray-300"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Pending Requests Card Example -->
	<div class="col-xl-3 col-md-6 mb-4">
		<div class="card border-left-warning shadow h-100 py-2">
			<div class="card-body">
				<div class="row no-gutters align-items-center">
					<div class="col mr-2">
						<div
							class="text-xs font-weight-bold text-warning text-uppercase mb-1">Users</div>
						<div class="h5 mb-0 font-weight-bold text-gray-800">
						${userNow}
						</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-user fa-2x text-gray-300"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Content Row -->

<div class="row">

	<!-- Area Chart -->
	<div class="col-xl-8 col-lg-7">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary">Doanh thu theo
					từng tháng</h6>
			</div>
			<!-- Card Body -->
			<div class="card-body">
				<div class="chart-area">
					<div id="curve_chart" style="width: 780px; height:  325px	"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- Pie Chart -->
	<div class="col-xl-4 col-lg-5">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary">Tồn Kho</h6>
			</div>
			<!-- Card Body -->
			<div class="card-body">
				<div id="piechart_3d" style="width: 370px; height: 325px;"></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var mydata1 = [ 
			[ 'Loại', 'Giá trị' ],
			<c:forEach var="array" items="${inventory}">
			[ '${array[0]}', ${array[2]} ], 
			</c:forEach>
			];
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable(mydata1);

		var options = {
			title : '',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
				chart.draw(data, options);
	}
</script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    var mydata2 = [ 
		[ 'Khách Hàng', 'Doanh số' ],
		<c:forEach var="array" items="${revenue}">
		[ '${array[0]}', ${array[2]} ], 
		</c:forEach>
		];
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable(mydata2);

        var options = {
          title: '',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>