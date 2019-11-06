<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản Phẩm</title>
<!-- jQuery -->
    <script src="/static/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/static/css/index.css" rel="stylesheet" />
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body class="container">
<h1 class="alert alert-success">Products Management</h1>
<jsp:include page="_form.jsp"></jsp:include>
<hr>
<jsp:include page="_table.jsp"></jsp:include>
</body>
</html>