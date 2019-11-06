<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>PRODUCTS EDITTON</h3>

<%-- <c:url var="actionUrl" value="/admin/nguoidung/index" /> --%>
<form:form modelAttribute="form" method="POST" acceptCharset="UTF-8">
	<div class="form-group">
		<label>Id</label>
		<form:input path="maSP" class="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Name</label>
		<form:input path="tenSP" class="form-control" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:input path="moTa" class="form-control" />
	</div>
	<div class="form-group">
		<label>Price</label>
		<form:input path="giaSP" class="form-control" />
	</div>
	<div class="form-group">
		<label>Quantity</label>
		<form:input path="soLuong" class="form-control" />
	</div>
	<div class="form-group">
		<label>Số lượng bán</label>
		<form:input path="soLuongBan" class="form-control" />
	</div>
	<div class="form-group">
		<label>Nha Cung Cap</label><br />
		<form:select path="nhaCungCap.maNCC" class="form-control">
			<form:options items="${nccs}"  itemValue="maNCC" itemLabel="tenNCC"/>
		</form:select>

	</div>
	<div class="form-group">
		<label>Danh Muc</label><br />
		<form:select path="danhMuc.maDM" class="form-control">
			<form:options items="${danhmuc}" itemValue="maDM" itemLabel="tenDM"/>
		</form:select>
	</div>
	<div class="form-group">
		<label>SPDacBiet</label>
		<form:select path="spDacBiet" cssClass="form-control">
			<form:option value="true" label="Có" />
			<form:option value="false" label="Không" />
		</form:select>
	</div>
	<div class="form-group">
		<label>SoLanXem</label>
		<form:input path="soLanXem" class="form-control" />
	</div>
	<div class="form-group">
		<label>GiamGia</label>
		<form:input path="giamGia" class="form-control" />
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/sanpham/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/sanpham/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/sanpham/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/sanpham/index">Reset</button>
	</div>
</form:form>