<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>DANH SÁCH SẢN PHẨM</h3>
<div class="search-product col-md-6">
	<input type="text" id="product" placeholder="Search ........">
</div>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Mã</th>
			<th>Sản phẩm</th>
			<th>Giá</th>
			<th>Giảm giá</th>
			<th>Nhà cung cấp</th>
			<th>Danh mục</th>
			<th>Số lương</th>
			<th>Số lượng bán</th>
			<th>Số lần xem</th>
			<th>SPDacBiet</th>
			<th>Mô tả</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.maSP}</td>
				<td>${product.tenSP}</td>
				<td><fmt:formatNumber value="${product.giaSP}" /></td>
				<td><fmt:formatNumber value="${product.giamGia}" /></td>
				<td>${product.nhaCungCap}</td>
				<td>${product.danhMuc}</td>
				<td>${product.soLuong}</td>
				<td>${product.soLuongBan}</td>
				<td>${product.soLanXem}</td>
				<td>${product.spDacBiet==true?"Đặc biệt":"Không đặc biệt"}</td>
				<td>${product.moTa}</td>
				<td><a href="/admin/sanpham/edit/${product.maSP}"
					class="btn btn-info">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

