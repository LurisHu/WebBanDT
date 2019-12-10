<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header -->
<!-- Navbar -->
<nav class="navbar nav1">
	<div class="navbar navbar-inverse">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown"><a href="#" id="nav2"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-th-list"></span> Danh mục sản phẩm</a>
					<ul class="dropdown-menu">
						<li><a id="A1" href="/customer/danhmuc/phone/0">Điện
								thoại</a></li>
						<li><a id="A1" href="/customer/danhmuc/laptop/0">Laptop</a></li>
						<li><a id="A1" href="#">Phụ kiện</a></li>
					</ul></li>
			</ul>
			<div class="col-sm-3 col-md-3">
				<form class="navbar-form" role="search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="q">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<ul class="nav navbar-nav navbar-nav2">
				<li><a href="/customer/sanpham/index" id="nav2"><span
						class="glyphicon glyphicon-home"></span> Trang chủ</a></li>
				<li><a href="#" id="nav2"><span
						class="glyphicon glyphicon-globe"></span> Giới thiệu</a></li>
				<li><a href="#" id="nav2"><span
						class="glyphicon glyphicon-bullhorn"></span> Tin tức</a></li>
				<li><a href="#" id="nav2"><span
						class="glyphicon glyphicon-question-sign"></span> Hỏi đáp</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" id="nav2"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span> <c:if
							test="${empty user}">
						Tài khoản
					</c:if> <c:if test="${not empty user}">
						${user}
					</c:if> <span class="caret"></span></a> <c:if test="${not empty user}">
						<ul class="dropdown-menu">
							<!-- Trigger the modal with a button -->
							<!-- <li><a id="A1" href="#" data-toggle="modal"
						data-target="#myModal1">Đăng nhập</a></li> -->
							<li><a id="A1" href="#">Thông tin cá nhân</a></li>
							<li><a id="A1" href="/account/update">Đổi mật khẩu</a></li>
							<li><a id="A1" href="/bill/view">Lịch sử mua hàng</a></li>
							<li><a id="A1" href="/account/logout">Đăng xuất</a></li>
						</ul>
					</c:if> <c:if test="${empty user}">
						<ul class="dropdown-menu">
							<!-- Trigger the modal with a button -->
							<!-- <li><a id="A1" href="#" data-toggle="modal"
						data-target="#myModal1">Đăng nhập</a></li> -->
							<li><a id="A1" href="/account/login">Đăng nhập</a></li>
							<li><a id="A1" href="/account/register">Đăng ký</a></li>
							<li><a id="A1" href="/account/forgot-password">Quên mật
									khẩu</a></li>
						</ul>
					</c:if></li>
				<!--  test -->
				<li><a href="/cart/view" id="nav2"><span
						class="glyphicon glyphicon-shopping-cart"></span> Giỏ hàng</a></li>
			</ul>
		</div>
	</div>
</nav>
<!-- End Navbar -->
