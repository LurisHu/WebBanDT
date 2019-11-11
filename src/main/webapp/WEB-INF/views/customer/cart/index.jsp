<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giỏ hàng</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Giá</th>
				<th>Số lương</th>
				<th>Giảm giá</th>
				<th>Tổng tiền</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p"
				items="${sessionScope['scopedTarget.cartService'].items}">
				<form:form modelAttribute="hoadonchitiet">
					<tr>
						<td>${p.maSP}</td>
						<td>${p.tenSP}</td>
						<td>${p.giaSP}</td>
						<td>${p.soLuong}</td>
						<td>${p.giamGia}</td>
						<td>${(p.giaSP*p.soLuong)-(p.giamGia*p.soLuong)}</td>
					</tr>
				</form:form>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Thành tiền:</td>
				<td>${sessionScope['scopedTarget.cartService'].amount}</td>
			</tr>
		</tbody>
	</table>
	<form:form modelAttribute="hoadonchitiet">
		<div class="form-group">
			<button class="btn btn-success" formaction="/cart/thanhtoan">Thanh
				toán</button>
		</div>
	</form:form>
</body>
</html>