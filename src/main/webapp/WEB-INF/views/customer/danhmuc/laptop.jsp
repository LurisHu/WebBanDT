<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="Categories-laptop">
	<div class="path">
		<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a href="/customer/danhmuc/laptop/0">Laptop</a>
	</div>
	<div class="banner">
		<img src="/static/images/AcerT11-C3.png" style="width: 100%; height: 160px;">
	</div>
	<div class="filter-bar-latop">
		<p class="filter-title-latop">Bộ lọc vừa áp dụng</p>
		<a class="filter-element-latop" href="#">Dưới 1 triệu</a>
	</div>
	<div class="clear-fix-laptop">
		<!-- Giao diện bên trái -->
		<div class="left-categories-laptop">
			<h2 class="left-title-laptop">Bộ lọc</h2>
			<div class="left-main-laptop">
				<div class="left-ri-laptop">
					<h4 class="left-rititle-laptop" data-toggle="collapse"
						data-target="#hang-san-xuat-laptop">Hãng sản xuất</h4>
					<div class="left-collapse-laptop" id="hang-san-xuat-laptop">
						<div class="left-scroll-laptop">
							<div class="scroll-inside-laptop">
								<div class="container-inside-laptop">
									<ul class="list-fillter-laptop">
										<li class="li-fillter-laptop"><label
											class="label-li-laptop">Tất cả <input type="checkbox"
												checked="checked"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Apple (Macbook) <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Asus <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Acer <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Dell <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Hp <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="left-main-laptop">
				<div class="left-ri-laptop">
					<h4 class="left-rititle-laptop" data-toggle="collapse"
						data-target="#muc-gia-laptop">Mức giá</h4>
					<div class="left-collapse-laptop" id="muc-gia-laptop">
						<div class="left-scroll-laptop">
							<div class="scroll-inside-laptop">
								<div class="container-inside-laptop">
									<ul class="list-fillter-laptop">
										<li class="li-fillter-laptop"><label
											class="label-li-laptop">Tất cả <input type="checkbox"
												checked="checked"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Dưới 10 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Từ 10 - 15 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Từ 15 - 20 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Từ 25 - 30 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Từ 30 - 35 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Từ 35 - 40 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
										</label> <label class="label-li-laptop">Trên 40 triệu <input
												type="checkbox"> <span class="checkmark-laptop"></span>
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
		<div class="right-categories-laptop">
			<div class="header-right-laptop">
				<div class="right-h1-laptop">
					<h1>LAPTOP</h1>
				</div>
				<div class="dropdown1-laptop">
					<button class="dropbtn-laptop">
						Sắp xếp theo giá:&nbsp;<span class="sort-text-laptop">Giá
							tăng dần</span>
					</button>
					<div class="dropdown-content-laptop">
						<a href="#">Giá tăng dần</a> <a href="#">Giá giảm dần</a>
					</div>
				</div>
			</div>
			<div class="right-prt-laptop">
				<c:forEach var="p" items="${Laptop}">
					<div class="right-prt-li-laptop">
						<a href="/customer/sanpham/detail/${p.maSP}"><img src="/static/images/${p.image}"
							class="img-laptop"></a>
						<div class="right-prt-if-laptop">
							<div class="prt-if-name-laptop">
								<h4>${p.tenSP}</h4>
								<div class="prt-if-price-laptop">
									<p>
										<fmt:formatNumber value="${p.giaSP}"/><sup>đ</sup>
									</p>
								</div>
								<div class="rating-categorie-laptop">
									<span class="glyphicon glyphicon-star categorie-laptop"></span>
									<span class="glyphicon glyphicon-star categorie-laptop"></span>
									<span class="glyphicon glyphicon-star categorie-laptop"></span>
									<span class="glyphicon glyphicon-star categorie-laptop"></span>
									<span class="glyphicon glyphicon-star categorie-laptop"></span>
								</div>
								<div class="prt-if-content-laptop">
									<ul>
										<li><label>Màn hình:15.4 inchs Retina</label></li>
										<li><label>RAM:&emsp;&emsp; 16 GB DDR4 2400 MHz</label></li>
										<li><label>CPU:&emsp;&emsp; Intel Core i9 8 -
												core</label></li>
										<li><label>VGA:&emsp;&emsp; Radeon Pro 560X 4 GB</label></li>
										<li><label>HĐH:&emsp;&emsp; Mac OS</label></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<ul class="pager">
					<li><a href="/customer/danhmuc/laptop/0">First</a></li>
					<li><a href="/customer/danhmuc/laptop/${pageNo-1}">Previous</a></li>
					<li><a href="/customer/danhmuc/laptop/${pageNo+1}">Next</a></li>
					<li><a href="/customer/danhmuc/laptop/${lastPageNo}">Last</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>