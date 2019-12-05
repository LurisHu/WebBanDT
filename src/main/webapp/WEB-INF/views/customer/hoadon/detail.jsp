<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>HÓA ĐƠN CHI TIẾT</h3>
<table class="table mt-5">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Sản phẩm</th>
			<th scope="col">Đơn giá</th>
			<th scope="col">Số Lượng</th>
			<th scope="col">Giảm giá</th>
			<th scope="col">Thành tiền</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="detail" items="${details}" varStatus="loop">
			<tr>
				<th>${loop.index+1}</th>
				<td>${detail.sanPhamHDCT}</td>
				<td><fmt:formatNumber value="${detail.giaSP}"/></td>
				<td>${detail.soLuong}</td>
				<td><fmt:formatNumber value="${detail.giamGia*detail.soLuong}"/></td>
				<td><fmt:formatNumber value="${(detail.giaSP*detail.soLuong)-(detail.giamGia*detail.soLuong)}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>