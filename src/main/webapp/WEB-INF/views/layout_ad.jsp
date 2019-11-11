<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin layout</title>
<link rel="stylesheet" type="text/css"
	href="/static/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header class="row">
			<div class="col-6">
				<img alt="logo" src="/static/images/logo.png" />
			</div>
			<div class="col-6">
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</header>
		<nav class="row">
			<jsp:include page="layout/admin/menu.jsp" />
		</nav>
		<div class="row">
			<article class="col-9">
				<tiles:insertAttribute name="body" />
			</article>
			<aside class="col-3">
				<jsp:include page="layout/admin/right.jsp" />
			</aside>
		</div>
		<footer class="row">FOOTER</footer>
	</div>
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