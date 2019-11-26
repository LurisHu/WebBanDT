<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/account/forgot-password" method="post">
<label style="color:red">${message}</label>
	<div class="form-group">
		<label for="password">Mật khẩu mới:</label> 
		<input id="password" type="password" class="form-control" name="password" placeholder="Nhập mật khẩu mới" required="required">
	</div>
	<div class="form-group">
		<label for="re-password">Nhập lại mật khẩu mới:</label> 
		<input id="re-password" type="password" class="form-control" name="re-password" placeholder="Nhập lại mật khẩu mới" required="required">
	</div>
	<button type="submit" class="btn btn-primary">Xác nhận</button>
</form>