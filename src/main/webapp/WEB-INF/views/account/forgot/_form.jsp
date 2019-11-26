<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/account/forgot-password" method="post">
<label style="color:red">${message}</label>
	<div class="form-group">
		<label for="email">Email:</label> 
		<input id="email" type="email" class="form-control" name="email" placeholder="Nhập địa chỉ mail để phục hồi mật khẩu" required="required">
	</div>
	<button type="submit" class="btn btn-primary">Xác nhận</button>
</form>