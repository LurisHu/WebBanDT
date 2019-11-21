<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="tab-pane">
	<form:form cssClass="form-horizontal" modelAttribute="nd">
		<form:hidden path="maNguoiDung" />
	<!-- ${message} -->
	<div class="form-group">
			<label class="col-sm-2 control-label">Họ tên</label>
			<div class="col-sm-5 has-success">
				<form:input cssClass="form-control" path="hoTen" />
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="hoTen" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-5 has-success">
				<form:input path="email" class="form-control" />
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="email" />
				<p style="color:red">${checkEmail}</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Mật khẩu</label>
			<div class="col-sm-5 has-success">
				<form:input path="matKhau" class="form-control" />
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="matKhau" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Ngày sinh</label>
			<div class="col-sm-5 has-success">
				<form:input path="ngaySinh" class="form-control" type="date" />
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="ngaySinh" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Giới tính</label>
			<div class="col-sm-5 has-success">
				<form:select path="gioiTinh" cssClass="form-control">
					<form:option value="true" label="Nam" />
					<form:option value="false" label="Nữ" />
				</form:select>
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="gioiTinh" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">Facebook</label>
			<div class="col-sm-5 has-success">
				<form:input path="mangXH" class="form-control" />
			</div>
		</div>

		<form:hidden path="loaiKH" value="0" />

		<div class="form-group">
			<label class="col-sm-2 control-label">Phone</label>
			<div class="col-sm-5 has-success">
				<form:input path="phone" class="form-control" />
			</div>
			<div class="col-sm-5 has-success">
				<form:errors path="phone" />
			</div>
		</div>

		<form:hidden path="isAdmin" value="false" />
		<form:hidden path="isActive" value="false" />
		<div class="form-group">
			<div class="col-sm-offset-2 control-label">
				<button class="btn btn-primary">Đăng ký</button>
			</div>
		</div>
	</form:form>
</div>