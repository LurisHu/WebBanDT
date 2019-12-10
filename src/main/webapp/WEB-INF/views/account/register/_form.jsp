<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="re-form">
	<form:form class="Re-form" modelAttribute="nd">
		<form:hidden path="maNguoiDung" />
		<div class="login-mod">
			<div class="form-row">
				<div class="form-group col-md-6 col-xs-6">
					<label for="phone"><b>Email</b></label>
					<form:input path="email" class="form-control control-re"
						placeholder="Vui lòng nhập Email" />
					<form:errors path="email" />
					<p style="color: red">${checkEmail}</p>
				</div>
				<div class="form-group col-md-6 col-xs-6">
					<label for="user-re"><b>Họ tên</b></label>
					<form:input class="form-control control-re" path="hoTen"
						placeholder="Vui lòng nhập Họ tên" />
					<form:errors path="hoTen" />
					<p></p>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-3 col-xs-6">
					<label for="email"><b>Facebook</b></label>
					<form:input path="mangXH" class="form-control control-re"
						placeholder="Vui lòng nhập Facebook" />
					<p></p>
				</div>
				<div class="form-group col-md-3 col-xs-6">
					<label for="email"><b>SĐT</b></label>
					<form:input path="phone" class="form-control control-re"
						placeholder="Vui lòng nhập SĐT" />
					<form:errors path="phone" />
					<p></p>
				</div>
				<div class="form-group col-md-6 col-xs-6">
					<label for="pass-re"><b>Mật khẩu</b></label>
					<form:input path="matKhau" class="form-control control-re"
						placeholder="Vui lòng nhập Mật khẩu" />
					<form:errors path="matKhau" />
					<p></p>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-3 col-xs-6">
					<label for="birth-re"><b>Ngày sinh</b></label>
					<form:input path="ngaySinh" class="form-control control-re"
						type="date" />
					<form:errors path="ngaySinh" />
					<p></p>
				</div>
				<div class="form-group col-md-3 col-xs-6">
					<label for="gender-re"><b>Giới tính</b></label>
					<form:select path="gioiTinh" class="form-control control-re">
						<form:option value="true" label="Nam" />
						<form:option value="false" label="Nữ" />
					</form:select>
					<p></p>
				</div>
				<form:hidden path="loaiKH" value="0" />
				<form:hidden path="isAdmin" value="false" />
				<form:hidden path="isActive" value="false" />
				<div class="form-group col-md-6 col-xs-6">
					<button type="submit" class="btn btn-block btn-re">Đăng ký</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
<br/>