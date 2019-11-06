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
				<th>Email</th>
				<th>Password</th>
				<th>Fullname</th>
				<th>Ngày sinh</th>
				<th>Giới tính</th>
				<th>Mạng xã hội</th>
				<th>Loại khách hàng</th>
				<th>Phone</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${nds}">
				<tr>
					<td>${user.maNguoiDung}</td>
					<td>${user.email}</td>
					<td>${user.matKhau}</td>
					<td>${user.hoTen}</td>
					<td><fmt:formatDate value="${user.ngaySinh}"
							pattern="dd-MM-yyyy" /></td>
					<td>${user.gioiTinh==true?"Nam":"Nữ"}</td>
					<td>${user.mangXH}</td>
					<td>${user.loaiKH==0?"Admin":user.loaiKH==1?"KH không thân thiết":user.loaiKH==2?"KH thân thiết":"Không rõ"}</td>
					<td>${user.phone}</td>
					<td><a href="/admin/nguoidung/edit/${user.maNguoiDung}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>