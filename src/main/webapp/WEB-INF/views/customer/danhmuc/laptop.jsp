<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- End Header -->
<div class="Categories">
	<div class="path">
		<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a href="/customer/danhmuc/laptop/0">Laptop</a>
	</div>
	<div class="banner">
		<img src="/static/images/Y11-C3.png" style="width: 100%; height: 160px;">
	</div>
	<div class="clear-fix">
		<!-- Giao diện bên phải -->
		<div class="right-categories">
			<div class="header-right">
				<div class="right-h1">
					<h1>LAPTOP</h1>
				</div>
			</div>
			<div class="right-prt">
				<c:forEach var="p" items="${Laptop}">
					<div class="right-prt-li">
						<a href="/customer/sanpham/detail/${p.maSP}"><img src="/static/images/${p.image}"
							class="img-phone"></a>
						<div class="right-prt-if">
							<div class="prt-if-name">
								<h4>${p.tenSP}</h4>
								<div class="prt-if-price">
									<p>
										<fmt:formatNumber value="${p.giaSP}"/><sup>đ</sup>
									</p>
								</div>
								<div class="rating-categorie">
									<span class="glyphicon glyphicon-star categorie"></span> <span
										class="glyphicon glyphicon-star categorie"></span> <span
										class="glyphicon glyphicon-star categorie"></span> <span
										class="glyphicon glyphicon-star categorie"></span> <span
										class="glyphicon glyphicon-star categorie"></span>
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
				</c:forEach>
			</div>
		</div>
		<!-- End Right -->
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