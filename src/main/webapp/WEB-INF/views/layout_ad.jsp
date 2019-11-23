<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin</title>

<!-- Custom fonts for this template-->
<link href="/static/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/static/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Phần đầu nek -->

		<!-- Sidebar -->
		<jsp:include page="layout/admin/_left.jsp" />
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="layout/admin/_header.jsp" />
				<!-- Logout Modal-->
				<!-- End of Topbar -->

				<!-- Hết header -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="row">
						<article class="col-12">
							<tiles:insertAttribute name="body" />
						</article>
					</div>
				</div>
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<jsp:include page="layout/admin/_footer.jsp" />
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="/static/vendor/jquery/jquery.min.js"></script>
	<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/static/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/static/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/static/js/demo/chart-area-demo.js"></script>
	<script src="/static/js/demo/chart-pie-demo.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="/static/js/modules/script.js"></script>
	<script type="text/javascript" src="/static/js/modules/upload.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.get('http://localhost:8080/api/city')
									.then(
											function(response) {
												console.log(response);
												for (i = 0; i < response.LtsItem.length; i++) {
													if (response.LtsItem[i].Title != "Chưa rõ") {
														$('#first')
																.append(
																		"<option value='"+response.LtsItem[i].ID+"-"+response.LtsItem[i].Title+"'>"
																				+ response.LtsItem[i].Title
																				+ "</option>");
													}
												}
											});
						});
	</script>
</body>
</html>