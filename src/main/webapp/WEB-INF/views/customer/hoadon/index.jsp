<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>HÓA ĐƠN CỦA BẠN</h3>
<table class="table mt-5">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Người Đặt</th>
			<th scope="col">Ngày Đặt</th>
			<th scope="col">Tổng tiền</th>
			<th scope="col">Địa chỉ giao</th>
			<th scope="col">Phí vận chuyển</th>
			<th scope="col">Comment</th>
			<th scope="col">Trạng thái</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="hoadon" items="${hoadons}" varStatus="loop">
			<tr>
				<th>${loop.index+1}</th>
				<td>${hoadon.nguoiDungHD}</td>
				<td><fmt:formatDate value="${hoadon.ngayDat}" pattern="dd-MM-yyyy" /></td>
				<td><fmt:formatNumber value="${hoadon.tongTien}" /></td>
				<td>${hoadon.diaChiGiao}</td>
				<td>${hoadon.phiVanChuyen}</td>
				<td>${hoadon.comment}</td>
				<td>${hoadon.tinhTrangHD}</td>
				<td><a href="/bill/detail/${hoadon.maHD}" class="btn btn-info">Xem chi tiết</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>