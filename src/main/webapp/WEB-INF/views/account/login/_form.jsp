<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="login-form" action="/account/login" method="post">
	<div class="login-mod">
		<div class="form-row">
			<div class="form-group col-md-6 col-xs-6">
				<label for="username"><b>Email</b></label> <input type="email"
					name="email" class="form-control control-login-user" id="email"
					placeholder="Vui lòng nhập Email" value="${nd.email}"
					required="required">
			</div>
			<div class="form-group col-md-6 col-xs-6">
				<button type="submit" class="btn btn-block btn-login">Đăng
					nhập</button>
				<p class="login-p">Hoặc đăng nhập bằng</p>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6 col-xs-6">
				<label for="pass"><b>Mật khẩu</b></label> <input type="password"
					class="form-control control-login-pass" id="password"
					placeholder="Vui lòng nhập Password" name="password"
					placeholder="Password" value="${nd.matKhau}" required="required">
				<p class="login-re">
					<a href="/account/forgot-password">Quên mật khẩu?</a>
				</p>
			</div>
			<div class="form-group col-md-6 col-xs-6">
				<button type="submit" class="btn btn-block btn-fb">Facebook</button>
			</div>
		</div>
	</div>
</form>