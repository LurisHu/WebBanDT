<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container-fluid body">
	<div class="col-sm-12">
		<div class="path">
			<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a
				href="/customer/sanpham/detail/${item.maSP}">Chi tiết sản phẩm</a>
		</div>
		<h3>
			<b>${item.tenSP}</b>
		</h3>
		<div class="col-sm-5">
			<div id="carousel" class="carousel slide carousel-fade"
				data-ride="carousel" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carousel" data-slide-to="0" class="active"></li>
					<li data-target="#carousel" data-slide-to="1"></li>
					<li data-target="#carousel" data-slide-to="2"></li>
					<li data-target="#carousel" data-slide-to="3"></li>
				</ol>

				<!-- Carousel items -->
				<div class="carousel-inner">
					<div class="item active">
						<div class="slide-content">
							<div class="slide-overlay door">
								<div class='title'>
									<img class="slide1" src="/static/images/${item.image}">
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide-content">
							<div class="slide-overlay door">
								<div class='title'>
									<img class="slide1" src="/static/images/${item.image}">
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide-content">
							<div class="slide-overlay door">
								<div class='title'>
									<img class="slide1" src="/static/images/${item.image}">
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide-content">
							<div class="slide-overlay door">
								<div class='title'>
									<img class="slide1" src="/static/images/${item.image}">
								</div>
							</div>
						</div>
					</div>
				</div>

				<a class="carousel-control left" href="#carousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="carousel-control right" href="#carousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>

			</div>
		</div>
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-horizontal form-detail">
						<div class="rating">
							<span class="glyphicon glyphicon-star star1"></span> <span
								class="glyphicon glyphicon-star star1"></span> <span
								class="glyphicon glyphicon-star star1"></span> <span
								class="glyphicon glyphicon-star star1"></span> <span
								class="glyphicon glyphicon-star star1"></span>
						</div>
						<div class="a">
							<p>
								<b>Giá: </b>
								<fmt:formatNumber value="${item.giaSP-item.giamGia}" />
							</p>
							<p>
								<b>Giá gốc: </b>
								<fmt:formatNumber value="${item.giaSP}" />
							</p>
							<p>
								<b>Tình trạng: </b> ${item.soLuong==0?"Hết hàng":"Còn hàng"}
							</p>
							<p>
								<b>Mô tả: </b>
							</p>
						</div>
						<p id="mota">${item.moTa}</p>
						<div class="form-group">
							<!-- <label class="control-label col-sm-4"><b>Số lượng:</b></label>
							<div class="col-sm-3">
								<input type="number" id="number" min="1" class="form-control"
									placeholder="1">
							</div> -->
						</div>
						<div>
							<button type="button" class="btn btn-lg" id="now">Mua
								ngay</button>
							<button class="btn btn-lg" id="addcart"
								formaction="/cart/add/${item.maSP}">Thêm vào giỏ</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="panel endow">
				<div class="panel-body">
					<ul>
						<li class="li"><span
							class="glyphicon glyphicon-ok-sign endow-ok"></span> Cam kết hàng
							chính hãng.</li>
						<li class="li"><span
							class="glyphicon glyphicon-ok-sign endow-ok"></span> Sản phẩm sẽ
							được bảo hành trong 12 tháng.</li>
						<li class="li"><span
							class="glyphicon glyphicon-ok-sign endow-ok"></span> Lỗi là đổi
							mới trong 1 tháng tại các chi nhánh toàn quốc.</li>
						<li class="li"><span
							class="glyphicon glyphicon-ok-sign endow-ok"></span> Giao hàng
							miễn phí toàn quốc</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="product">
		<div class="col-sm-12">
			<h3>Điện thoại tương tự</h3>
		</div>
		<div class="col-sm-12">
			<div class="panel ">
				<div class="panel-body">
					<div class="showproduct">
						<c:forEach var="p" items="${BestSellerPhone}">
							<div class="col-sm-2 detail-prt">
								<a href="/customer/sanpham/detail/${p.maSP}"><img
									src="/static/images/${p.image}" id="similar-product"></a> <br>
								<div class="text-center similar-product">
									<p>${p.tenSP}</p>
									<b>
										<p id="color-price">
											<fmt:formatNumber value="${p.giaSP}"/>
										</p>
									</b>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12 evaluate">
			<h2>Đặc điểm nổi bật</h2>
		</div>
		<div class="col-sm-4">
			<div class="panel product-detail">
				<div class="panel-body">
					<div class="col-sm-12 TSKT">
						<h4>
							<b>Thông số kỹ thuật</b>
						</h4>
					</div>
					<table class="table">
						<tr>
							<th>Màng hình:</th>
							<td>LTPS LCD, 6.5", Full HD+</td>
						</tr>
						<tr>
							<th>Hệ điều hành:</th>
							<td>Android 9.0 (Pie)</td>
						</tr>
						<tr>
							<th>RAM:</th>
							<td>6 GB</td>
						</tr>
						<tr>
							<th>Bộ nhớ trong:</th>
							<td>12 GB</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="panel product-detail">
				<div class="panel-body">
					<div class="TK&TL">
						<h4>
							<b>Thiết kế & Trọng lượng</b>
						</h4>
					</div>
					<table class="table">
						<tr>
							<th>Thiết kế:</th>
							<td>Nguyên khối</td>
						</tr>
						<tr>
							<th>Chất liệu:</th>
							<td>Nhựa</td>
						</tr>
						<tr>
							<th>RAM:</th>
							<td>6 GB</td>
						</tr>
						<tr>
							<th>Trọng lượng:</th>
							<td>190 g</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="panel product-detail">
				<div class="panel-body">
					<div class="TTP&S">
						<h4>
							<b>Thông tin Pin & Sạc</b>
						</h4>
					</div>
					<table class="table">
						<tr>
							<th>Dung lượng:</th>
							<td>4000 mAh</td>
						</tr>
						<tr>
							<th>Loại pin:</th>
							<td>Pin chuẩn Li-Ion</td>
						</tr>
						<tr>
							<th>RAM:</th>
							<td>6 GB</td>
						</tr>
						<tr>
							<th>Công nghệ Pin:</th>
							<td>Tiết kiệm pin, Sạc nhanh VOOC</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-8 comment">
			<div class="toprt">
				<div class="crt">
					<div class="lcrt">
						<b>4.0&nbsp;<span class="glyphicon glyphicon-star"></span></b>
					</div>
					<div class="rcrt">
						<div class="r">
							5&nbsp;<span class="glyphicon glyphicon-star"></span>
							<div class="bgb">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%"></div>
							</div>
						</div>
					</div>
					<div class="rcrt">
						<div class="r">
							4&nbsp;<span class="glyphicon glyphicon-star"></span>
							<div class="bgb">
								<div class="progress-bar progress-bar-primary"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%"></div>
							</div>
						</div>
					</div>
					<div class="rcrt">
						<div class="r">
							3&nbsp;<span class="glyphicon glyphicon-star"></span>
							<div class="bgb">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
									style="width: 40%"></div>
							</div>
						</div>
					</div>
					<div class="rcrt">
						<div class="r">
							2&nbsp;<span class="glyphicon glyphicon-star"></span>
							<div class="bgb">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%"></div>
							</div>
						</div>
					</div>
					<div class="rcrt">
						<div class="r">
							1&nbsp;<span class="glyphicon glyphicon-star"></span>
							<div class="bgb">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
									style="width: 40%"></div>
							</div>

						</div>
					</div>
					<button class="btn btn-success button-bcrt" data-toggle="collapse"
						data-target="#demo">Gửi đánh giá của bạn</button>
				</div>
				<div id="demo" class="collapse">
					<p>Bạn đánh giá sản phẩm này bao nhiêu?</p>
					<div class="form-group" id="rating-ability-wrapper">
						<label class="control-label" for="rating"> <span
							class="field-label-info"></span> <input type="hidden"
							id="selected_rating" name="selected_rating" value=""
							required="required">
						</label>
						<h2 class="bold rating-header">
							<span class="selected-rating">0</span><small> / 5</small>
						</h2>
						<button type="button" class="btnrating btn btn-default "
							data-attr="1" id="rating-star-1">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</button>
						<button type="button" class="btnrating btn btn-default "
							data-attr="2" id="rating-star-2">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</button>
						<button type="button" class="btnrating btn btn-default "
							data-attr="3" id="rating-star-3">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</button>
						<button type="button" class="btnrating btn btn-default "
							data-attr="4" id="rating-star-4">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</button>
						<button type="button" class="btnrating btn btn-default "
							data-attr="5" id="rating-star-5">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						</button>
						<script src="js/ab.js"></script>
					</div>
					<textarea class="f-cmttarea fsformsc"
						placeholder="Mời bạn đánh giá"></textarea>
					<button type="submit" class="btn btn-danger btn-lg"
						id="btn-collapse">Đăng</button>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-12">
		<h2>Nhận xét</h2>
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Media Top</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<hr>
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Media Middle</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<hr>
	</div>
</div>

<%-- <h1>Product Detail</h1>
	<ul>
		<li>${item.maSP}</li>
	</ul>
	<img src="/static/images/${item.image}" height="200px" width="200px" /> --%>
