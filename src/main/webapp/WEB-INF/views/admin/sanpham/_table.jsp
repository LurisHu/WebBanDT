<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>LIST OF PRODUCTS</h3>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Số lượng bán</th>
			<th>Nha Cung Cap</th>
			<th>Danh Muc</th>
			<th>SPDacBiet</th>
			<th>SoLanXem</th>
			<th>GiamGia</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.maSP}</td>
				<td>${product.tenSP}</td>
				<td>${product.moTa}</td>
				<td>${product.giaSP}</td>
				<td>${product.soLuong}</td>
				<td>${product.soLuongBan}</td>
				<td>${product.nhaCungCap}</td>
				<td>${product.danhMuc}</td>
				<td>${product.spDacBiet==true?"Đặc biệt":"Không đặc biệt"}</td>
				<td>${product.soLanXem}</td>
				<td>${product.giamGia}</td>
				<td><a href="/admin/sanpham/edit/${product.maSP}">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>