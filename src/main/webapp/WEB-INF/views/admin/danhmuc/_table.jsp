<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>DANH SÁCH DANH MỤC</h3>
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
		<c:forEach var="dm" items="${dms}" varStatus="loop">
			<tr>
				<th>${loop.index+1}</th>
				<td>${dm.maDM}</td>
				<td>${dm.tenDM}</td>
				<td>${dm.moTa}</td>
				<td><a href="/admin/danhmuc/edit/${dm.maDM}" class="btn btn-info">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>