<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- End Header -->
<div class="Categories">
	<div class="path">
		<a href="/customer/sanpham/index">Trang chủ</a>&nbsp;/&nbsp;<a href="/customer/danhmuc/phone/0">Điện
			thoại</a>
	</div>
	<div class="banner">
		<img src="/static/images/Y11-C3.png" style="width: 100%; height: 160px;">
	</div>
	<div class="clear-fix">
		<!-- Giao diện bên phải -->
		<div class="right-categories">
			<div class="header-right">
				<div class="right-h1">
					<h1>ĐIỆN THOẠI</h1>
				</div>
			</div>
			<div class="right-prt">
				<c:forEach var="p" items="${Phone}">
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
										<c:forTokens items="${p.cauHinhSP}" delims="\\|" var="mySplit">
											<li><label><c:out value="${mySplit}" /></label></li>
										</c:forTokens>
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
					<li><a href="/customer/danhmuc/phone/0">First</a></li>
					<li><a href="/customer/danhmuc/phone/${pageNo-1}">Previous</a></li>
					<li><a href="/customer/danhmuc/phone/${pageNo+1}">Next</a></li>
					<li><a href="/customer/danhmuc/phone/${lastPageNo}">Last</a></li>
				</ul>
			</div>
	</div>
</div>