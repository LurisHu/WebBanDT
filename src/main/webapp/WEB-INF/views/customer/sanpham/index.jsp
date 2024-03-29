<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body class="container">
	<div class="container1">
		<div class="row">
			<!-- Slideshow -->
			<article class="col-sm-8">
				<div id="slideshow-example" data-component="slideshow">
					<div role="list">
						<div class="slide">
							<img src="/static/images/Banner.jpg" class="slideshow" />
						</div>
						<div class="slide">
							<img src="/static/images/cong-nghe.jpg" class="slideshow" />
						</div>
						<div class="slide">
							<img src="/static/images/banner-samsung.jpg" class="slideshow" />
						</div>
					</div>
				</div>
				<script src="/static/js/slideshow.js"></script>
			</article>
			<!-- End Slideshow -->
			<!-- aside -->
			<aside class="col-sm-4">
				<img src="/static/images/bannerweb.png" class="img1" /> <img
					src="/static/images/Smart-phone.jpg" class="img1" /> <img
					src="/static/images/laptop2.jpg" class="img11" />
			</aside>
			<!-- End aside -->
			<!-- Banner -->
			<div class="col-md-12">
				<div class="banner-img">
					<img id="img2" src="/static/images/school2.png" />
				</div>
			</div>
			<!-- End Banner -->
			<!-- Showproduct -->
			<div class="product">
				<div class="col-sm-12">
					<strong>Điện thoại bán chạy nhất</strong>
				</div>
				<div class="showproduct">
					<c:forEach var="p" items="${BestSellerPhone}">
						<a href="/customer/sanpham/detail/${p.maSP}">
							<div class="col-sm-4 col-xs-4 panel-group"
								style="cursor: pointer;">
								<div class="panel">
									<div class="panel-heading">
										<h4>
											<b>${p.tenSP}</b>
										</h4>
										<h4 id="price">
											<b><fmt:formatNumber value="${p.giaSP}" />đ</b>
										</h4>
										<p></p>
									</div>
									<div class="panel-body">
										<div class="col-sm-7">
											<p class="index-mota">
												<span class="glyphicon glyphicon-ok-sign"></span> ${p.moTa}
											</p>
											<p>
												<span class="label label-danger">Khuyến mãi</span>
											</p>
											<p>
												<b>
													<h4>
														<fmt:formatNumber value="${p.giamGia}" />
														đ
													</h4>
												</b>
											</p>
											<p>
												<span class="label label-warning"><b>Trả góp 0%</b></span>
											</p>
										</div>
										<div class="col-sm-5">
											<img id="img3" src="/static/images/${p.image}" />
										</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
				<div class="col-sm-12">
					<strong>Laptop bán chạy nhất</strong>
				</div>
				<div class="showproduct">
					<c:forEach var="p" items="${BestSellerLaptop}">
						<a href="/customer/sanpham/detail/${p.maSP}">
							<div class="col-sm-4 col-xs-4 panel-group"
								style="cursor: pointer;">
								<div class="panel">
									<div class="panel-heading">
										<h4>
											<b>${p.tenSP}</b>
										</h4>
										<h4 id="price">
											<b><fmt:formatNumber value="${p.giaSP}" />đ</b>
										</h4>
										<p></p>
									</div>
									<div class="panel-body">
										<div class="col-sm-7">
											<p class="index-mota">
												<span class="glyphicon glyphicon-ok-sign "></span> ${p.moTa}
											</p>
											<p>
												<span class="label label-danger">Khuyến mãi</span>
											</p>
											<p>
												<b>
													<h4>
														<fmt:formatNumber value="${p.giamGia}" />
														đ
													</h4>
												</b>
											</p>
											<p>
												<span class="label label-warning"><b>Trả góp 0%</b></span>
											</p>
										</div>
										<div class="col-sm-5">
											<img id="img4" src="/static/images/${p.image}" />

										</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
				<div class="col-sm-12">
					<strong>Phụ kiện bán chạy nhất</strong>
				</div>
				<div class="showproduct">
					<c:forEach var="p" items="${BestSellerPhuKien}">
						<a href="/customer/sanpham/detail/${p.maSP}">
							<div class="col-sm-4 col-xs-4 panel-group"
								style="cursor: pointer;">
								<div class="panel">
									<div class="panel-heading">
										<h4>
											<b>${p.tenSP}</b>
										</h4>
										<h4 id="price">
											<b><fmt:formatNumber value="${p.giaSP}" />đ</b>
										</h4>

									</div>
									<div class="panel-body">
										<div class="col-sm-7 ">
											<p class="index-mota">
												<span class="glyphicon glyphicon-ok-sign"></span> ${p.moTa}
											</p>
											<p>
												<span class="label label-danger">Khuyến mãi</span>
											</p>
											<p>
												<b>
													<h4>
														<fmt:formatNumber value="${p.giamGia}" />
														đ
													</h4>
												</b>
											</p>
											<p>
												<span class="label label-warning"><b>Trả góp 0%</b></span>
											</p>
										</div>
										<div class="col-sm-5">
											<img id="img4" src="/static/images/${p.image}" />
										</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
			<!-- End showproduct -->
		</div>
	</div>
</body>
