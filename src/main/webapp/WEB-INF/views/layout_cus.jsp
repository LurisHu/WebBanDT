<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User layout</title>
<link rel="stylesheet" type="text/css"
	href="/static/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header class="row">
			<img alt="logo" src="/static/images/logo.png" />
		</header>
		<nav class="row">
			<jsp:include page="layout/customer/menu.jsp" />
		</nav>
		<div class="row">
			<article class="col-9">
				<tiles:insertAttribute name="body" />
			</article>
			<aside class="col-3">
				<jsp:include page="layout/customer/right.jsp" />
			</aside>
		</div>
		<footer class="row">Nội dung của footer</footer>
	</div>
	<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>