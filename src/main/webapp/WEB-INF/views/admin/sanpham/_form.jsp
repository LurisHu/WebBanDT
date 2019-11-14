<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>PRODUCTS EDITTON</h3>

<%-- <c:url var="actionUrl" value="/admin/nguoidung/index" /> --%>
<form:form modelAttribute="form" method="POST"
	enctype="multipart/form-data" acceptCharset="UTF-8">
	<div class="form-group">
		<label>Id</label>
		<form:input path="maSP" class="form-control" readonly="true" />
	</div>
	<div class="form-group">
		<label>Name</label>
		<form:input path="tenSP" class="form-control" />
	</div>
	<div class="form-group">
		<label>Photo</label> <input type="file" name="up_photo"
			onchange="openFile(this)" />
		<form:hidden path="image" />
		<img id="anh" style="max-width:200" src="/static/images/${form.image==null?'default.png':form.image}">
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
		<label>Số lượng sản phẩm</label>
		<form:input path="soLuong" class="form-control" />
	</div>
	<div class="form-group">
		<label>Số lượng đã bán</label>
		<form:input path="soLuongBan" class="form-control" />
	</div>
	<div class="form-group">
		<label>Nhà cung cấp</label><br />
		<form:select path="nhaCungCap.maNCC" class="form-control">
			<form:options items="${nccs}" itemValue="maNCC" itemLabel="tenNCC" />
		</form:select>

	</div>
	<div class="form-group">
		<label>Danh mục</label><br />
		<form:select path="danhMuc.maDM" class="form-control">
			<form:options items="${danhmuc}" itemValue="maDM" itemLabel="tenDM" />
		</form:select>
	</div>
	<div class="form-group">
		<label>SP Đặc biệt</label>
		<form:select path="spDacBiet" cssClass="form-control">
			<form:option value="true" label="Có" />
			<form:option value="false" label="Không" />
		</form:select>
	</div>
	<div class="form-group">
		<label>View count</label>
		<form:input path="soLanXem" class="form-control" />
	</div>
	<div class="form-group">
		<label>Giảm giá</label>
		<form:input path="giamGia" class="form-control" />
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/sanpham/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/sanpham/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/sanpham/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/sanpham/index">Reset</button>
	</div>
</form:form>