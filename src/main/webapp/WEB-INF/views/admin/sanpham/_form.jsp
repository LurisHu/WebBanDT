<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<span id="error">${message}</span>
<form:form modelAttribute="product" method="POST"
	enctype="multipart/form-data" acceptCharset="UTF-8">
	<div class="form-row">
		<div class="form-group col-md-3">
			<label for="inputId">Id</label>
			<form:input path="maSP" type="text" class="form-control" id="inputId"
				readonly="true" />
		</div>
		<div class="form-group col-md-9">
			<label for="inputName">Tên sản phẩm</label>
			<form:input path="tenSP" type="text" class="form-control"
				id="inputName" placeholder=" Nhập tên sản phẩm" />
			<form:errors path="tenSP" />
		</div>
	</div>
	<div class="form-group">
		<label for="description">Mô tả</label>
		<form:textarea path="moTa" class="form-control" id="description"
			rows="3" />
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="quantity">Số lượng sản phẩm</label>
			<form:input path="soLuong" type="number" class="form-control"
				id="quantity" />
			<form:errors path="soLuong" />
		</div>
		<div class="form-group col-md-6">
			<label for="quantity-sold">Số lượng đã bán</label>
			<form:input path="soLuongBan" type="text" class="form-control"
				id="quantity-sold" readonly="true" />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="supplier">Nhà cung cấp</label>
			<form:select path="nhaCungCap.maNCC" class="form-control">
				<form:options items="${nccs}" itemValue="maNCC" itemLabel="tenNCC" />
			</form:select>
		</div>
		<div class="form-group col-md-6">
			<label for="item">Danh mục</label>
			<form:select path="danhMuc.maDM" class="form-control">
				<form:options items="${danhmuc}" itemValue="maDM" itemLabel="tenDM" />
			</form:select>
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="special-product">Sản phẩm đặt biệt</label>
			<form:select path="spDacBiet" cssClass="form-control">
				<form:option value="true" label="Có" />
				<form:option value="false" label="Không" />
			</form:select>
		</div>
		<div class="form-group col-md-6">
			<label for="view-count">Lượt xem</label>
			<form:input path="soLanXem" class="form-control" readonly="true" />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="Price">Giá</label>
			<form:input path="giaSP" type="number" class="form-control"
				id="discount" />
			<form:errors path="giaSP" />
		</div>
		<div class="form-group col-md-6">
			<label for="discount">Giảm giá</label>
			<form:input path="giamGia" type="number" class="form-control"
				id="discount" />
			<form:errors path="giamGia" />
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-5">
			<label for="inputId">Chọn ảnh</label><br />
			<form:errors path="image" />
			<input type="file" name="up_photo" onchange="openFile(this)" />
			<form:hidden path="image" />
			<img id="anh"
				src="/static/images/${product.image==null?'default.png':product.image}"
				height="192px" width="192px">
		</div>
		<div class="form-group col-md-7"></div>
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/sanpham/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/sanpham/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/sanpham/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/sanpham/index">Reset</button>
	</div>
</form:form>
