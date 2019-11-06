<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="nd">
	<form:hidden path="maNguoiDung" class="form-control" />
	<div class="form-group">
		<label>Mật khẩu</label>
		<form:input path="matKhau" class="form-control" />
	</div>
	<div class="form-group">
		<label>Họ tên</label>
		<form:input path="hoTen" class="form-control" />
	</div>
	<div class="form-group">
		<label>Ngày sinh</label>
		<form:input path="ngaySinh" class="form-control" type="date" />
	</div>
	<div class="form-group">
		<label>Giới tính</label>
		<form:select path="gioiTinh" cssClass="form-control">
			<form:option value="true" label="Nam" />
			<form:option value="false" label="Nữ"  />
		</form:select>
	</div>
	<div class="form-group">
		<label>Facebook</label>
		<form:input path="mangXH" class="form-control" />
	</div>
	<div class="form-group">
		<label>Loại khách hàng</label>
		<form:select path="loaiKH" cssClass="form-control">
			<form:option value="0" label="Admin" />
			<form:option value="1" label="KH mới"/>
			<form:option value="2" label="KH thân thiết"  />
		</form:select>
	</div>
	<div class="form-group">
		<label>Phone</label>
		<form:input path="phone" class="form-control" />
	</div>
	<div class="form-group">
		<label>Email</label>
		<form:input path="email" class="form-control" />
	</div>
	<div class="form-group">
		<label for="type">Là người quản trị</label>
		<form:select path="isAdmin" cssClass="form-control">
			<form:option value="true" label="Có" />
			<form:option value="false" label="Không"  />
		</form:select>
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/nguoidung/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/nguoidung/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/nguoidung/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/nguoidung/index">Reset</button>
	</div>
</form:form>