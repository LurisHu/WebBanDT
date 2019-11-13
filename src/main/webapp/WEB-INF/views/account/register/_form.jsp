<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="nd">
	<form:hidden path="maNguoiDung"/>
	
	<div class="form-group">
		<label>Họ tên</label>
		<form:input path="hoTen" class="form-control" />
	</div>
	
	<div class="form-group">
		<label>Email</label>
		<form:input path="email" class="form-control" />
	</div>
	
	<div class="form-group">
		<label>Mật khẩu</label>
		<form:input path="matKhau" class="form-control" />
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
	
	<form:hidden path="loaiKH" value="0"/>
	
	<div class="form-group">
		<label>Phone</label>
		<form:input path="phone" class="form-control" />
	</div>
	
	<form:hidden path="isAdmin" value="false"/>
	
	<div class="form-group">
		<button class="btn btn-primary">Đăng ký</button>
	</div>
</form:form>