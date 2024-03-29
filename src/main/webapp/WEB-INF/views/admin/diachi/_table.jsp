<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>DANH SÁCH ĐỊA CHỈ</h3>
<div class="table-responsive">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Địa chỉ</th>
				<th>Tỉnh</th>
				<th>Quận/Huyện</th>
				<th>Phường/Xã</th>
				<th>Địa chỉ của</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${dcs}">
				<tr>
					<th>${user.maDiaChi}</th>
					<th>${user.diaChi}</th>
					<th>${user.tenTinh}</th>
					<th>${user.quanHuyen}</th>
					<th>${user.phuongXa}</th>
					<th>${user.nguoiDungDC}</th>
					<th><a href="/admin/diachi/edit/${user.maDiaChi}">Edit</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>