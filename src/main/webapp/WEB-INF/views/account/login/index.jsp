<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="login-container">
	<div class="login-header">
		<div class="login-left">
			<p>&nbsp;Đăng nhập ngay!</p>
			<label style="color: red; float: left; margin-bottom: -25px; margin-left: 15px; margin-top: 4px;">${message}</label>
		</div>
		<br>
		<div class="login-right">
			<p>
				Thành viên mới?&nbsp;<a href="/account/register">Đăng ký tại đây</a>
			</p>
		</div>
	</div>
	<jsp:include page='_form.jsp' />
</div>
<br/><br/><br/><br/>