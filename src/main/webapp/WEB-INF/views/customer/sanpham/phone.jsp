<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="Categories">
	<div class="path">
		<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a
			href="/customer/sanpham/phone">Điện thoại</a>
	</div>
	<div class="banner">
		<img src="/static/images/Y11-C3.png"
			style="width: 100%; height: 160px;">
	</div>
	<div class="filter-bar">
		<p class="filter-title">Bộ lọc vừa áp dụng</p>
		<a class="filter-element" href="#">Dưới 1 triệu</a>
	</div>
	<div class="clear-fix">
		<!-- Giao diện bên trái -->
		<div class="left">
			<h2 class="left-title">Bộ lọc</h2>
			<div class="left-main">
				<div class="left-ri">
					<h4 class="left-rititle" data-toggle="collapse"
						data-target="#hang-san-xuat">Hãng sản xuất</h4>
					<div class="left-collapse" id="hang-san-xuat">
						<div class="left-scroll">
							<div class="scroll-inside">
								<div class="container-inside">
									<ul class="list-fillter">
										<li class="li-fillter"><label class="label-li">Tất
												cả <input type="checkbox" checked="checked"> <span
												class="checkmark"></span>
										</label> <label class="label-li">Apple <input type="checkbox">
												<span class="checkmark"></span>
										</label> <label class="label-li">Oppo <input type="checkbox">
												<span class="checkmark"></span>
										</label> <label class="label-li">Samsung <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Vivo <input type="checkbox">
												<span class="checkmark"></span>
										</label> <label class="label-li">Nokia <input type="checkbox">
												<span class="checkmark"></span>
										</label></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="left-main">
				<div class="left-ri">
					<h4 class="left-rititle" data-toggle="collapse"
						data-target="#muc-gia">Mức giá</h4>
					<div class="left-collapse" id="muc-gia">
						<div class="left-scroll">
							<div class="scroll-inside">
								<div class="container-inside">
									<ul class="list-fillter">
										<li class="li-fillter"><label class="label-li">Tất
												cả <input type="checkbox" checked="checked"> <span
												class="checkmark"></span>
										</label> <label class="label-li">Dưới 1 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Từ 1 - 3 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Từ 3 - 6 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Từ 6 - 10 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Từ 10 - 15 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Từ 15 - 10 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label> <label class="label-li">Trên 15 triệu <input
												type="checkbox"> <span class="checkmark"></span>
										</label></li>

									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Left -->
		<!-- Giao diện bên phải -->
		<div class="right">
			<div class="header-right">
				<div class="right-h1">
					<h1>ĐIỆN THOẠI</h1>
				</div>
				<div class="dropdown1">
					<button class="dropbtn">
						Sắp xếp theo giá:&nbsp;<span class="sort-text">Giá tăng dần</span>
					</button>
					<div class="dropdown-content">
						<a href="#">Giá tăng dần</a> <a href="#">Giá giảm dần</a>
					</div>
				</div>
			</div>
			<div class="right-prt">
				<c:forEach var="p" items="${Phone}">
					<a href="/customer/sanpham/detail/${p.maSP}">
						<div class="right-prt-li">
							<img src="/static/images/${p.image}">
							<div class="right-prt-if">
								<div class="prt-if-name">
									<h4>${p.tenSP}</h4>
									<div class="rating">
										<span class="glyphicon glyphicon-star star"></span> <span
											class="glyphicon glyphicon-star star"></span> <span
											class="glyphicon glyphicon-star star"></span> <span
											class="glyphicon glyphicon-star star"></span> <span
											class="glyphicon glyphicon-star star"></span>
									</div>
									
									<div class="prt-if-price">
										<p>
											<fmt:formatNumber value="${p.giaSP}" />
											<sup>đ</sup>
										</p>
									</div>
									
									
									<div class="prt-if-content">
										<ul>
											<li><label>Màn hình:1242 x 2688 Pixels 6.5 inchs</label></li>
											<li><label>Camera:&ensp; Triple 12MP Ultra Wide,
													Wide and Telephoto cameras 12.0 MP</label></li>
											<li><label>Pin:&emsp;&emsp;&ensp; Lâu hơn iPhone
													Xs Max 5h</label></li>
											<li><label>RAM:&emsp;&emsp; 4 GB</label></li>
											<li><label>CPU:&emsp;&emsp; Apple A13 Bionic</label></li>
											<li><label>HĐH:&emsp;&emsp; IS0 13</label></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
		<!-- End Right -->
	</div>
</div>