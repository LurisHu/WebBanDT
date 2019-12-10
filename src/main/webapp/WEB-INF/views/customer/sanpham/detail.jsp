<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container-fluid body">
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v5.0&appId=460287461293455&autoLogAppEvents=1"></script>
	<div class="col-sm-12">
		<div class="path">
			<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a
				href="/customer/sanpham/detail/${item.maSP}">Chi tiết sản phẩm</a>
		</div>
		<h3>
			<b>${item.tenSP}</b>
		</h3>
		<div class="col-sm-5">
			<img class="slide1 img-thumbnail" src="/static/images/${item.image}">
		</div>
		<div class="col-sm-4 detail-ct">
			<div class="panel panel-default ">
				<div class="panel-body">
					<form class="form-horizontal form-detail ">
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
								đ
							</p>
							<p>
								<b>Giá gốc: </b>
								<fmt:formatNumber value="${item.giaSP}" />
								đ
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
							<button class="btn btn-lg" id="now"
								formaction="/cart/buynow/${item.maSP}">Mua ngay</button>
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
		<div class="col-sm-12 text-detail">
			<h3>Sản phẩm tương tự</h3>
		</div>
		<div class="col-sm-12 pr-detail">
			<div class="panel ">
				<div class="panel-body">
					<div class="showproduct">
						<c:forEach var="p" items="${item.danhMuc.sanPham}" begin="0"
							end="5">
							<div class="col-sm-2 detail-prt">
								<a href="/customer/sanpham/detail/${p.maSP}"><img
									src="/static/images/${p.image}" id="similar-product"></a> <br>
								<div class="text-center similar-product">
									<p>${p.tenSP}</p>
									<b>
										<p id="color-price">
											<fmt:formatNumber value="${p.giaSP}" />
											đ
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
			<h2>Đặc điểm nổi bật của&nbsp;${item.tenSP}</h2>
		</div>
		<div class="col-sm-6 DB">
			<img class=" img-DB" src="/static/images/${item.image}">
		</div>
		<div class="col-sm-6">
			<div class="panel product-detail">
				<div class="panel-body">
					<div class="TKTL">
						<h4>
							<b>Thông tin kỹ thuật</b>
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
		<h2>#Nhận xét</h2>
		<div class="media">
			<div class="fb-comments"
				data-href="http://localhost:8080/${requestScope['javax.servlet.forward.request_uri']}"
				data-width="" data-numposts="5"></div>
		</div>
		<hr>
	</div>
</div>
