<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="Fg-form" action="/account/forgot-password" method="post">
	<label style="color: red">${message}</label>
	<div class="Fg-mod">
		<div class="p-top1">
			<p>Vui lòng nhập email bạn muốn lấy lại mật khẩu.</p>
		</div>
		<div class="p-body">
			<p>Nhập email tại đây!</p>
			<div class="form-group col-md-7">
				<input id="email" type="email" class="form-control  control-Fg"
					name="email" placeholder="Nhập địa chỉ mail để phục hồi mật khẩu"
					required="required">
			</div>
		</div>
		<div class="p-footer">
			<div class="form-group col-md-3">
				<button type="submit" class="btn btn-block btn-Fg">Lấy lại
					mật khẩu</button>
			</div>
		</div>
		<div class="back-Fg">
			<p>
				<a href="/account/login"><span class="glyphicon glyphicon-backward"></span>&nbsp;Quay
					lại</a>
			</p>
		</div>
	</div>
</form>
<br/><br/><br/><br/>