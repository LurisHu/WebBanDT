<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>LIST OF USERS</h3>
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
					<td>${user.maDiaChi}</td>
					<td>${user.diaChi}</td>
					<td>${user.tenTinh}</td>
					<td>${user.quanHuyen}</td>
					<td>${user.phuongXa}</td>
					<td>${user.nguoiDungDC}</td>
					<td><a href="/admin/diachi/edit/${user.maDiaChi}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>