<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="nd">
	<form:hidden path="maNguoiDung" class="form-control" />
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4">Email</label>
			<form:input path="email" class="form-control" id="inputEmail4"
				placeholder="Nhập Email" />
		</div>
		<div class="form-group col-md-6">
			<label for="inputPassword4">Password</label>
			<form:input path="matKhau" type="password" class="form-control"
				id="inputPassword4" placeholder=" Nhập Password" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputAddress">Họ tên</label>
		<form:input path="hoTen" type="text" class="form-control"
			id="inputAddress" placeholder="Nhập họ tên" />
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputBirthday">Ngày sinh</label>
			<form:input path="ngaySinh" type="date" class="form-control"
				id="birthday" />
		</div>
		<div class="form-group col-md-6">
			<label for="inputGender">Giới tính</label>
			<form:select path="gioiTinh" cssClass="form-control">
				<form:option value="true" label="Nam" />
				<form:option value="false" label="Nữ" />
			</form:select>
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-7">
			<label for="inputFb">Facebook</label>
			<form:input path="mangXH" class="form-control" id="fb" />
		</div>
		<div class="form-group col-md-5">
			<label for="input-customer">Loại khách hàng</label> <select
				id="Ct-type" class="form-control">
				<option selected>Khách hàng mới</option>
				<option>Khách hàng thân thiết</option>
			</select>
		</div>
	</div>
	<div class="form-group ">
		<label for="inputPhone">Phone</label>
		<form:input path="phone" type="text" class="form-control" id="phone" />
	</div>
	<div class="form-group">
		<button class="btn btn-primary"
			formaction="/admin/nguoidung/customer/create">Create</button>
		<button class="btn btn-warning"
			formaction="/admin/nguoidung/customer/update">Update</button>
		<button class="btn btn-danger"
			formaction="/admin/nguoidung/customer/delete">Delete</button>
		<button class="btn btn-info"
			formaction="/admin/nguoidung/customer/index">Reset</button>
	</div>
</form:form>