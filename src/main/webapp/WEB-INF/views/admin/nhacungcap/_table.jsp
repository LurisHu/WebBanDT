<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>DANH SÁCH NHÀ CUNG CẤP</h3>
<table class="table mt-5">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Mã nhà cung cấp</th>
			<th scope="col">Tên</th>
			<th scope="col">Mô tả</th>
			<th scope="col">Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ncc" items="${nccs}" varStatus="loop">
			<tr>
				<th>${loop.index+1}</th>
				<th>${ncc.maNCC}</th>
				<th>${ncc.tenNCC}</th>
				<th>${ncc.moTa}</th>
				<th><a href="/admin/nhacungcap/edit/${ncc.maNCC}" class="btn btn-info">Edit</a></th>
			</tr>
		</c:forEach>
	</tbody>
</table>