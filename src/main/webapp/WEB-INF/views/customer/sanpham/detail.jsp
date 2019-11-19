<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- jQuery -->
<script src="static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/index.css" rel="stylesheet" />
<script src="static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="col-sm-12">
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
						<form class="form-horizontal form-detail" method="post">
							<div class="row">
								<div class="rating">
									<input type="radio" id="star5" name="rating" value="5" /><label
										for="star5" title="Meh">5 stars</label> <input type="radio"
										id="star4" name="rating" value="4" /><label for="star4"
										title="Kinda bad">4 stars</label> <input type="radio"
										id="star3" name="rating" value="3" /><label for="star3"
										title="Kinda bad">3 stars</label> <input type="radio"
										id="star2" name="rating" value="2" /><label for="star2"
										title="Sucks big tim">2 stars</label> <input type="radio"
										id="star1" name="rating" value="1" /><label for="star1"
										title="Sucks big time">1 star</label>
								</div>
							</div>
							<p>
								<b>Giá: </b>
								<fmt:formatNumber value="${item.giaSP-item.giamGia}" />
							</p>
							<p>
								<b>Giá gốc: </b>
								<fmt:formatNumber value="${item.giaSP}" />
							</p>
							<p>
								<b>Tình trạng:</b> ${item.soLuong==0?"Hết hàng":"Còn hàng"}
							</p>
							<p>
								<b>Mô tả:</b>
							</p>
							<p id="mota">${item.moTa}</p>
							<div class="form-group">
								<label class="control-label col-sm-4"><b>Số lượng:</b></label>
								<div class="col-sm-3">
									<input type="number" id="number" min="1" class="form-control"
										placeholder="1">
								</div>
							</div>
							<div>
								<button type="button" class="btn btn-lg" id="now">Mua
									ngay</button>
								<button class="btn btn-lg" id="addcart" formaction="/cart/add/${item.maSP}">Thêm
									vào giỏ</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel">
					<div class="panel-body">
						<ul>
							<li>Cam kết hàng chính hãng.</li>
							<li>Sản phẩm sẽ được baor hành trong 12 tháng.</li>
							<li>Lỗi là đổi mới trong 1 tháng tại các chi nhánh toàn
								quốc.</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="product">
			<div class="col-sm-12">
				<strong>Sản phẩm liên quan</strong>
			</div>
			<div class="col-sm-12">
				<div class="panel">
					<div class="panel-body">
						<div class="showproduct">
						<c:forEach var="p" items="${BestSellerPhone}">
							<div class="col-sm-2">
								<a href="/customer/sanpham/detail/${p.maSP}"><img src="/static/images/${p.image}"
									id="similar-product"></a> <br>
								<div class="text-center similar-product">
									<p>${p.tenSP}</p>
									<b>
										<p id="color-price"><fmt:formatNumber value="${p.giaSP}" /></p>
									</b>
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel">
					<div class="panel-body">
						<table class="table table-condensed">
							<tr>
								<th>Name:</th>
								<td>Bill Gates</td>
							</tr>
							<tr>
								<th>Telephone:</th>
								<td>55577854</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- <h1>Product Detail</h1>
	<ul>
		<li>${item.maSP}</li>
	</ul>
	<img src="/static/images/${item.image}" height="200px" width="200px" /> --%>
</body>
</html>