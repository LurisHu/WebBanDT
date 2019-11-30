<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="cart-container">
	<div class="cart-header">
		<h3>Giỏ hàng của bạn</h3>
		<a href="/customer/sanpham/index"
			style="float: right; margin-top: -30px;">Mua thêm sản phẩm khác</a>
	</div>
	<div class="panel panel-cart">
		<div class="panel-body">

			<c:if
				test="${not empty sessionScope['scopedTarget.cartService'].items}">
				<c:forEach var="p"
					items="${sessionScope['scopedTarget.cartService'].items}">
					<form method="post">
						<div class="panel panel-mini">
							<div class="panel-body">
								<img class="panel-img" src="/static/images/${p.image}"
									style="max-width: 120px; height: 120px;">
								<div class="name-item">
									<h4>
										<b>${p.tenSP}</b>
									</h4>
								</div>
								<div class="price-item ">
									<h4>
										<fmt:formatNumber value="${p.giaSP}" />
										<sup>đ</sup>
									</h4>
								</div>
								<div class="quantity buttons_added number-item">
									<c:if test="${p.soLuong > 1}">
										<input type="submit" value="-" class="minus"
											formaction="/removeQty/${p.maSP}">
									</c:if>
									<input type="number" step="1" min="1" max="" name="quantity"
										value="${p.soLuong}" title="Qty" class="input-text qty text"
										size="4" pattern="" inputmode="" readonly="readonly">
										<input type="submit" value="+" formaction="/addQty/${p.maSP}"
										class="plus">
								</div>
								<div class="delete-cart">
									<button type="submit" class="btn btn-default btn-cart"
										formaction="/cart/remove/${p.maSP}">
										<span class="glyphicon glyphicon-remove-sign"></span>
									</button>
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
				<div class="panel">
					<div class="panel-body">
						<div class="sum">
							<h3>
								<b>Tổng tiền:&ensp;<span style="color: red;"><fmt:formatNumber
											value="${sessionScope['scopedTarget.cartService'].amount}" /><sup>đ</sup></span></b>
							</h3>
						</div>
					</div>
				</div>
				<div class="DCGH">
					<h3>Địa chỉ giao hàng</h3>
				</div>

				<div class="information">
					<form:form modelAttribute="hoadonchitiet"
						class="form-horizontal form-information">
						<div class="form-group">
							<label class=" col-sm-2 label-information">Họ tên</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="Họ tên của bạn">
							</div>
						</div>
						<div class="form-group">
							<label class=" col-sm-2 label-information">Số điện thoại</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="Số điện thoại của bạn">
							</div>
						</div>
						<div class="form-group">
							<label class=" col-sm-2 label-information">Tỉnh/Thành phố</label>
							<div class="col-md-10">
								<select id="first" class="form-control">
									<option value="0" selected="selected">Chọn Tỉnh/Thành
										phố</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class=" col-sm-2 label-information">Quận/Huyện</label>
							<div class="col-md-10">
								<select id="second" class="form-control" disabled="disabled">
									<option value="0" selected="selected">Chọn Quận/Huyện</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class=" col-sm-2 label-information">Phường/Xã</label>
							<div class="col-md-10">
								<select id="third" class="form-control" disabled="disabled">
									<option value="0" selected="selected">Chọn Phường/Xã</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class=" col-sm-2 label-information" for="message">Địa
								chỉ</label>
							<div class="col-md-10">
								<textarea name="text" cols="30" rows="3" class="form-control"
									placeholder="Ví dụ: 52, đường Trần Hưng Đạo"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-submit"
									formaction="/cart/thanhtoan">Thanh toán</button>
							</div>
						</div>
					</form:form>
				</div>
			</c:if>
			<c:if test="${empty sessionScope['scopedTarget.cartService'].items}">
				<div class="panel panel-mini">
					<div class="panel-body">
						<h4>Giỏ hàng của bạn chưa có sản phẩm</h4>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>