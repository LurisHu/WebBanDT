<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/static/images/iphone11.png" rel="shortcut icon" type="image/x-icon">
<!-- jQuery -->
<script src="/static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
<link href="/static/css/index.css" rel="stylesheet" />
<link href="/static/css/detail.css" rel="stylesheet" />
<script src="/static/js/bootstrap.min.js"></script>
</head>
<body  class="container-fluid">
	<div>
		<header class="row">
			<jsp:include page="layout/customer/_header.jsp" />
		</header>
		<div class="container1">
			<div class="row">
				<%-- <article class="col-sm-8">
					<jsp:include page="layout/customer/_left.jsp" />
				</article>
				<aside class="col-sm-4">
					<jsp:include page="layout/customer/_right.jsp" />
				</aside> --%>
				<article class="col-9">
				<tiles:insertAttribute name="body"/>
			</article>
			</div>
		</div>
		<footer class="row">
			<jsp:include page="layout/customer/_footer.jsp" />
		</footer>
	</div>
</body>
</html>