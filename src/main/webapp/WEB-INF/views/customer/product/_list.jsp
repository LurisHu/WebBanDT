<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table mt-5">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Mã danh mục</th>
			<th scope="col">Tên</th>
			<th scope="col">Mô tả</th>
			<th scope="col">Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="sp" items="${list}" varStatus="loop">
			<tr>
				<th>${loop.index+1}</th>
				<td>${sp.maSP}</td>
				<td>${dm.tenSP}</td>
				<td>${dm.moTa}</td>
				<td><a href="/admin/danhmuc/edit/${dm.maSP}">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>