<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>DANH SÁCH ADMIN</h3>
<div class="search-product col-md-6">
	<form method="post">
		<input type="text" id="product" placeholder="Search ........" name="search">
		<button class="btn btn-info" style="float: right"
			formaction="/admin/nguoidung/admin/search">Search</button>
	</form>
</div>
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
				<th>Quyền hạn</th>
				<th>Phone</th>
				<th>Trạng thái hoạt động</th>
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
					<td>${user.loaiKH==0?"Admin":user.loaiKH==1?"Khách hàng mới":user.loaiKH==2?"Khách hàng thân thiết":"Không rõ"}</td>
					<td>${user.isAdmin==true?"Người quản trị":"Khách hàng"}</td>
					<td>${user.phone}</td>
					<td>${user.isActive==false?"Chưa kích hoạt":"Đã kích hoạt"}</td>
					<td><a href="/admin/nguoidung/admin/edit/${user.maNguoiDung}"
						class="btn btn-info">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>