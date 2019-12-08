<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="bill-container">
	<div class="panel bill-panel">
		<div class="p-top">
			<p>
				<span class="glyphicon glyphicon-ok"></span>&ensp;ĐẶT HÀNG THÀNH
				CÔNG
			</p>
		</div>
		<div class="panel-body">
			<div class="tks">
				<p>Cảm ơn (Anh/Chị) Kiệt đã mua hàng tại trang Web của chúng
					tôi. Chúng tôi đảm bảo sản phẩm giao đến là sản phẩm tốt nhất dành
					cho quý khách.</p>
			</div>
			<div class="panel-default">
				<div class="panel-heading">
					<p>THÔNG TIN ĐẶT HÀNG</p>
				</div>
				<div class="panel-body body-mini">
					<p>* Địa chỉ đặt hàng: ${diachi}</p>
					<p>*Thanh toán khi nhận được hàng.</p>
					<p>
						*Tổng tiền:&ensp;<span><fmt:formatNumber
								value="${sessionScope['scopedTarget.cartService'].amount}" /><sup>đ</sup></span>
					</p>
				</div>
				<div class="panel-footer footer-mini">
					<p>
						Trước khi giao hàng chúng tôi sẽ gọi quý khách để xác nhận đơn
						hàng. Khi cần hỗ trợ vui lòng gọi vào số máy <span>0972977617</span>&nbsp;từ
						(7h30p - 22h) để được hỗ trợ.
					</p>
				</div>
			</div>
			<div class="purchased">
				<div class="panel-default">
					<div class="panel-heading">
						<p>SẢM PHẨM ĐÃ MUA</p>
					</div>
					<c:forEach var="p"
						items="${sessionScope['scopedTarget.cartService'].items}">
						<div class="panel-body body-mini">
							<img class="bill-img" src="/static/images/${p.image}"
								style="max-width: 120px; height: 120px;">
							<div class="bill-item">
								<h4>
									<b>${p.tenSP}</b>
								</h4>
							</div>
							<div class="bill-price">
								<p>
									<fmt:formatNumber value="${p.giaSP}" />
									<sup>đ</sup>
								</p>
							</div>
							<div class="bill-number">
								<p>
									Số lượng:&nbsp;<span>${p.soLuong}</span>
								</p>
							</div>
						</div>
					</c:forEach>
					<div class="panel-footer footer-mini">
						<p>Chúng tôi sẽ giao hàng sớm nhất cho quý khách. Đảm bảo hàng
							mà quý khách nhận được là mới 100% và còn nguyên vẹn khi đến tay
							quý khách.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<p>
				<span>Lưu ý:</span>&nbsp; Nếu có sơ xuất trong lúc giao hàng xin quý
				khách hãy báo lại với chúng tôi để được đổi mới sản phẩm.
			</p>
			<div class="bill-back">
				<a href="/customer/sanpham/index" class="btn btn-info">Mua thêm
					sản phẩm khác</a>
			</div>
		</div>
	</div>
</div>