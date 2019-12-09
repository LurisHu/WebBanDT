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
<div class="container-fluid">
	<div class="form-product">
		<div class="row">
			<div class="col-sm-12">
				<div class="text-center">
					<h1>QUẢN LÝ SẢN PHẨM</h1>
				</div>
				<jsp:include page="_form.jsp"></jsp:include>
				<hr>
				<jsp:include page="_table.jsp"></jsp:include>
			</div>
		</div>
	</div>
</div>
<div>
	<ul class="pager">
		<li><a href="/admin/sanpham/index/0">First</a></li>
		<li><a href="/admin/sanpham/index/${pageNo-1}">Previous</a></li>
		<li><a href="/admin/sanpham/index/${pageNo+1}">Next</a></li>
		<li><a href="/admin/sanpham/index/${lastPageNo}">Last</a></li>
	</ul>
</div>
<!-- End Form -->

