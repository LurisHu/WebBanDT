<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div class="form-admin">
	<div class="row">
		<div class="col-sm-12">
			<div class="text-center">
				<h1>QUẢN LÝ HÓA ĐƠN</h1>
			</div>
			<jsp:include page="_form.jsp"></jsp:include>
			<hr>
			<jsp:include page="_table.jsp"></jsp:include>
		</div>
	</div>
</div>
<div class="text-center">
	<a href="/admin/hoadon/index/0" class="btn btn-outline-success">First</a> 
	<a href="/admin/hoadon/index/${pageNo-1}" class="btn btn-outline-success">Previous</a>
	<a href="/admin/hoadon/index/${pageNo+1}" class="btn btn-outline-success">Next</a>
	<a href="/admin/hoadon/index/${lastPageNo}" class="btn btn-outline-success">Last</a>
</div>
