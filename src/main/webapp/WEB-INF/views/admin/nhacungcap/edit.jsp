<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhà cung cấp</title>
</head>
<style type="text/css">
span[id*=errors] {
	color: red;
	font-style: italic;
	background-image: url("/static/images/fire-icon.png");
	background-repeat: no-repeat;
	padding-left: 25px;
}

span[id*=error] {
	color: red;
	font-style: italic;
	padding-bottom: 5px;
}
</style>
<body>
	<jsp:include page="_form.jsp"></jsp:include>
	<hr>
	<jsp:include page="_table.jsp"></jsp:include>
</body>
</html>