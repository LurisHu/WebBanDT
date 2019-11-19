<%@ page pageEncoding="utf-8"%>
<!-- Header -->
<!-- Navbar -->
<nav class="navbar nav1">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-left">
			<li class="dropdown"><a href="#" id="nav2"
				class="dropdown-toggle" data-toggle="dropdown"><span
					class="glyphicon glyphicon-th-list"></span> Danh mục sản phẩm</a>
				<ul class="dropdown-menu">
					<li><a id="A1" href="#">Điện thoại</a></li>
					<li><a id="A1" href="#">Máy tính bảng</a></li>
					<li><a id="A1" href="#">Laptop</a></li>
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
		<ul class="nav navbar-nav">
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
					class="glyphicon glyphicon-user"></span> Sign up <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<!-- Trigger the modal with a button -->
					<li><a id="A1" href="#" data-toggle="modal"
						data-target="#myModal1">Đăng nhập</a></li>
					<li><a id="A1" href="#">Thông tin cá nhân</a></li>
					<li><a id="A1" href="#">Đổi mật khẩu</a></li>
					<li><a id="A1" href="#">Lịch sử mua hàng</a></li>
					<li><a id="A1" href="#">Đăng xuất</a></li>
				</ul></li>
			<!--  test -->
			<li><a href="/cart/view" id="nav2"><span
					class="glyphicon glyphicon-shopping-cart"></span> Giỏ hàng</a></li>
		</ul>
	</div>
</nav>
<!-- End Navbar -->
<!-- Modal 2 -->
<div id="myModal2" class="modal modal-child" data-backdrop-limit="1"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	aria-hidden="true" data-modal-parent="#myModal1">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title text-center">
					<strong>Quên mật khẩu</strong>
				</h3>
			</div>
			<div class="modal-body modal-body2">
				<form class="form-horizontal modal2">
					<p>Vui lòng nhập tài khoản bạn muốn lấy lại mật khẩu.</p>
					<div class="form-group">
						<label id="text-modal2"><h4>Số điện thoại hoặc email:</h4></label>
						<div class="col-sm-10">
							<input type="text" class="form-control">
						</div>
					</div>
					<button type="button" class="btn btn-danger btn-lg btn-moldal2">Phục
						hồi</button>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" data-dismiss="modal"
					data-dismiss="modal" aria-hidden="true">Cancel</button>
			</div>
		</div>
	</div>
</div>
<!-- End Modal 2 -->
<!-- Modal -->
<div class="container">
	<div class="modal fade" id="myModal1" role="dialog" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="row">
					<div class="modal-body">
						<div class="col-md-4">
							<div class="panel-body">
								<h1>Đăng nhập</h1>
								<img src="/static/images/images.png" />
								<p>Đăng nhập để theo dõi đơn hàng, lưu háo đơn của bạn cũng
									như nhận nhiều ưu đãi hấp dẫn khác.
							</div>
						</div>
						<div class="col-md-8 col">
							<div class="panel panel-default">
								<div class="panel-body">
									<ul class="nav nav-tabs" id="myTab">
										<li class="active"><a data-toggle="tab" href="#login">Đăng
												nhập</a></li>
										<li><a data-toggle="tab" href="#register">Tạo tài
												khoản</a></li>
									</ul>
									<div class="tab-content">
										<div id="login" class="tab-pane fade in active">
											<form class="tablogin" action="/account/login" method="post">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span> <input id="email"
														type="email" class="form-control" name="email"
														placeholder="Email" value="${user.email}"
														required="required">
												</div>
												<br>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-lock"></i></span> <input id="password"
														type="password" class="form-control" name="password"
														placeholder="Password" value="${user.matKhau}"
														required="required">
												</div>
												<br>
												<p>
													Quên mật khẩu? Nhấn vào <a href="#myModal2"
														data-toggle="modal" role="dialog">đây</a>
												</p>
												<button class="btn btn-block">Login</button>
												<br>
												<button class="btn btn-block btn2">Đăng nhập bằng
													Facebook</button>
											</form>
										</div>
										<div id="register" class="tab-pane fade">
											<form class="form-horizontal">
												<div class="form-group ">
													<label class="col-sm-2 control-label">Họ tên</label>
													<div class="col-sm-10 has-success ">
														<input type="text" class="form-control"
															placeholder="Họ tên">
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label">SĐT</label>
													<div class="col-sm-10 has-success ">
														<input type="text" class="form-control"
															placeholder="Số điện thoại">
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label">Email</label>
													<div class="col-sm-10 has-success ">
														<input type="text" class="form-control"
															placeholder="Email">
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label">Giới tính</label>
													<div class="radio1">
														<input type="radio" name="demo" value="one" id="radio-one"
															class="form-radio" checked><label for="radio-one">Nam</label>
														<input type="radio" name="demo" value="one" id="radio-one"
															class="form-radio" checked><label for="radio-one">Nữ</label>
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label">Mật khẩu</label>
													<div class="col-sm-10 has-success ">
														<input type="text" class="form-control"
															placeholder="Mật khẩu">
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label">Sinh năm</label>
													<div class="col-sm-8 has-success ">
														<input id="textdate" type="date" class="form-control ">
													</div>
												</div>
												<div class="form-group ">
													<label class="col-sm-2 control-label"></label>
													<div class="col-sm-8 has-success ">
														<button class="btn btn-block  bt1">Đăng ký</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button"
						class="btn btn-outline-info waves-effect ml-auto btn-info"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>